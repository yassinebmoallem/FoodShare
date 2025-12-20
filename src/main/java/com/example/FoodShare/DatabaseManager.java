package com.example.FoodShare;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:foodsharing.db";

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            Statement stmt = conn.createStatement();

            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT UNIQUE NOT NULL," +
                    "location TEXT NOT NULL," +
                    "phone TEXT NOT NULL," +
                    "password TEXT NOT NULL," +
                    "role TEXT NOT NULL)";
            stmt.execute(createUsersTable);

            String createMealsTable = "CREATE TABLE IF NOT EXISTS meals (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "quantity INTEGER NOT NULL," +
                    "description TEXT NOT NULL," +
                    "location TEXT NOT NULL," +
                    "donor_id INTEGER NOT NULL," +
                    "created_at TEXT NOT NULL," +
                    "FOREIGN KEY (donor_id) REFERENCES users(id))";
            stmt.execute(createMealsTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerUser(User user) {
        String sql = "INSERT INTO users (name, email, location, phone, password, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getLocation());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getRole());

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("location"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean addMeal(Meal meal) {
        String sql = "INSERT INTO meals (name, quantity, description, location, donor_id, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, meal.getName());
            pstmt.setInt(2, meal.getQuantity());
            pstmt.setString(3, meal.getDescription());
            pstmt.setString(4, meal.getLocation());
            pstmt.setInt(5, meal.getDonorId());
            pstmt.setString(6, meal.getCreatedAt().toString());

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Meal> getDonorMeals(int donorId) {
        List<Meal> meals = new ArrayList<>();
        String sql = "SELECT m.*, u.name as donor_name, u.phone as donor_phone FROM meals m " +
                "JOIN users u ON m.donor_id = u.id WHERE m.donor_id = ? ORDER BY m.created_at DESC";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, donorId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                meals.add(new Meal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getInt("donor_id"),
                        rs.getString("donor_name"),
                        rs.getString("donor_phone"),
                        LocalDateTime.parse(rs.getString("created_at"))
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meals;
    }

    public static List<Meal> getAllMeals() {
        List<Meal> meals = new ArrayList<>();
        String sql = "SELECT m.*, u.name as donor_name, u.phone as donor_phone FROM meals m " +
                "JOIN users u ON m.donor_id = u.id ORDER BY m.created_at DESC";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                meals.add(new Meal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getInt("donor_id"),
                        rs.getString("donor_name"),
                        rs.getString("donor_phone"),
                        LocalDateTime.parse(rs.getString("created_at"))
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meals;
    }
}
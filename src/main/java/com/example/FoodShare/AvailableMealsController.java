package com.example.FoodShare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class AvailableMealsController {

    @FXML
    private VBox mealsContainer;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
        loadMeals();
    }

    private void loadMeals() {
        mealsContainer.getChildren().clear();

        List<Meal> meals = DatabaseManager.getAllMeals();

        if (meals.isEmpty()) {
            Label emptyLabel = new Label("لا توجد وجبات متاحة حالياً");
            emptyLabel.setFont(new Font(16));
            emptyLabel.setTextFill(Color.GRAY);
            mealsContainer.getChildren().add(emptyLabel);
            mealsContainer.setAlignment(Pos.CENTER);
        } else {
            for (Meal meal : meals) {
                VBox mealCard = createMealCard(meal);
                mealsContainer.getChildren().add(mealCard);
            }
        }
    }

    private VBox createMealCard(Meal meal) {
        VBox card = new VBox(10);
        card.setStyle("-fx-background-color: #e3f2fd; -fx-padding: 20; -fx-border-color: #2196F3; -fx-border-width: 1; -fx-border-radius: 5; -fx-background-radius: 5;");

        Label nameLabel = new Label("🍽️ " + meal.getName());
        nameLabel.setFont(new Font("System Bold", 18));

        Label quantityLabel = new Label("الكمية: " + meal.getQuantity() + " وجبة");
        quantityLabel.setFont(new Font(14));

        Label locationLabel = new Label("📍 الموقع: " + meal.getLocation());
        locationLabel.setFont(new Font(14));

        Label donorLabel = new Label("👤 المتبرع: " + meal.getDonorName());
        donorLabel.setFont(new Font(14));
        donorLabel.setTextFill(Color.web("#1976D2"));

        Label phoneLabel = new Label("📞 رقم الهاتف: " + meal.getDonorPhone());
        phoneLabel.setFont(new Font(14));
        phoneLabel.setTextFill(Color.web("#388E3C"));

        Label dateLabel = new Label("📅 تاريخ الإضافة: " + meal.getFormattedDate());
        dateLabel.setFont(new Font(13));
        dateLabel.setTextFill(Color.web("#F57C00"));

        Label descLabel = new Label("الوصف: " + meal.getDescription());
        descLabel.setFont(new Font(13));
        descLabel.setWrapText(true);
        descLabel.setTextFill(Color.GRAY);

        card.getChildren().addAll(nameLabel, quantityLabel, locationLabel, donorLabel, phoneLabel, dateLabel, descLabel);

        return card;
    }

    @FXML
    protected void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("receiver-view.fxml"));
            Parent root = loader.load();

            ReceiverController controller = loader.getController();
            controller.setUser(currentUser);

            Stage stage = (Stage) mealsContainer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
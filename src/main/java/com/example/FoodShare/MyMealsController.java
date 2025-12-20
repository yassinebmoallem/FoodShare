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

public class MyMealsController {

    @FXML
    private VBox mealsContainer;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
        loadMeals();
    }

    private void loadMeals() {
        mealsContainer.getChildren().clear();

        List<Meal> meals = DatabaseManager.getDonorMeals(currentUser.getId());

        if (meals.isEmpty()) {
            Label emptyLabel = new Label("لا توجد وجبات حالياً");
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
        card.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20; -fx-border-color: #ddd; -fx-border-width: 1; -fx-border-radius: 5; -fx-background-radius: 5;");

        Label nameLabel = new Label("🍽️ " + meal.getName());
        nameLabel.setFont(new Font("System Bold", 18));

        Label quantityLabel = new Label("الكمية: " + meal.getQuantity() + " وجبة");
        quantityLabel.setFont(new Font(14));

        Label locationLabel = new Label("📍 الموقع: " + meal.getLocation());
        locationLabel.setFont(new Font(14));

        Label dateLabel = new Label("📅 تاريخ الإضافة: " + meal.getFormattedDate());
        dateLabel.setFont(new Font(13));
        dateLabel.setTextFill(Color.web("#F57C00"));

        Label descLabel = new Label("الوصف: " + meal.getDescription());
        descLabel.setFont(new Font(13));
        descLabel.setWrapText(true);
        descLabel.setTextFill(Color.GRAY);

        card.getChildren().addAll(nameLabel, quantityLabel, locationLabel, dateLabel, descLabel);

        return card;
    }

    @FXML
    protected void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donor-view.fxml"));
            Parent root = loader.load();

            DonorController controller = loader.getController();
            controller.setUser(currentUser);

            Stage stage = (Stage) mealsContainer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
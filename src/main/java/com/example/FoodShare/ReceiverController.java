package com.example.FoodShare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReceiverController {

    @FXML
    private Label welcomeLabel;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
        welcomeLabel.setText("مرحباً " + user.getName());
    }

    @FXML
    protected void handleViewAvailableMeals() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("available-meals-view.fxml"));
            Parent root = loader.load();

            AvailableMealsController controller = loader.getController();
            controller.setUser(currentUser);

            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.example.FoodShare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    protected void handleLogin() {
        errorLabel.setText("");

        String email = emailField.getText().trim();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("بيانات غير صحيحة");
            return;
        }

        User user = DatabaseManager.loginUser(email, password);

        if (user == null) {
            errorLabel.setText("بيانات غير صحيحة");
            return;
        }

        try {
            FXMLLoader loader;
            if (user.getRole().equals("متبرع")) {
                loader = new FXMLLoader(getClass().getResource("donor-view.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("receiver-view.fxml"));
            }

            Parent root = loader.load();

            if (user.getRole().equals("متبرع")) {
                DonorController controller = loader.getController();
                controller.setUser(user);
            } else {
                ReceiverController controller = loader.getController();
                controller.setUser(user);
            }

            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
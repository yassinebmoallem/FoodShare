package com.example.FoodShare;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField phoneField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label messageLabel;

    @FXML
    protected void handleCreateAccount() {
        messageLabel.setText("");

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String location = locationField.getText().trim();
        String phone = phoneField.getText().trim();
        String role = roleComboBox.getValue();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (name.isEmpty() || email.isEmpty() || location.isEmpty() ||
                phone.isEmpty() || role == null || password.isEmpty() || confirmPassword.isEmpty()) {
            showError("هناك خطأ: يرجى ملء جميع الحقول");
            return;
        }

        if (!email.contains("@")) {
            showError("هناك خطأ: البريد الإلكتروني غير صحيح");
            return;
        }

        if (!phone.matches("\\d+")) {
            showError("هناك خطأ: رقم الهاتف يجب أن يحتوي على أرقام فقط");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("هناك خطأ: كلمة السر غير متطابقة");
            return;
        }

        User newUser = new User(name, email, location, phone, password, role);
        boolean success = DatabaseManager.registerUser(newUser);

        if (success) {
            showSuccess("تم إنشاء الحساب بنجاح");

            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> goToLoginPage());
            pause.play();
        } else {
            showError("هناك خطأ: البريد الإلكتروني مستخدم بالفعل");
        }
    }

    @FXML
    protected void handleBack() {
        goToLoginPage();
    }

    private void showError(String message) {
        messageLabel.setText(message);
        messageLabel.setTextFill(Color.RED);
    }

    private void showSuccess(String message) {
        messageLabel.setText(message);
        messageLabel.setTextFill(Color.GREEN);
    }

    private void goToLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
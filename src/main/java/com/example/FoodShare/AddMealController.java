package com.example.FoodShare;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AddMealController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField locationField;

    @FXML
    private Label messageLabel;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
    }

    @FXML
    protected void handleAddMeal() {
        messageLabel.setText("");

        String name = nameField.getText().trim();
        String quantityStr = quantityField.getText().trim();
        String description = descriptionField.getText().trim();
        String location = locationField.getText().trim();

        if (name.isEmpty() || quantityStr.isEmpty() || description.isEmpty() || location.isEmpty()) {
            showError("يرجى ملء جميع الحقول");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                showError("الكمية يجب أن تكون رقم موجب");
                return;
            }
        } catch (NumberFormatException e) {
            showError("الكمية يجب أن تكون رقم صحيح");
            return;
        }

        Meal meal = new Meal(name, quantity, description, location, currentUser.getId());
        boolean success = DatabaseManager.addMeal(meal);

        if (success) {
            showSuccess("تمت إضافة الوجبة بنجاح");

            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> goToDonorPage());
            pause.play();
        } else {
            showError("حدث خطأ أثناء إضافة الوجبة");
        }
    }

    @FXML
    protected void handleBack() {
        goToDonorPage();
    }

    private void showError(String message) {
        messageLabel.setText(message);
        messageLabel.setTextFill(Color.RED);
    }

    private void showSuccess(String message) {
        messageLabel.setText(message);
        messageLabel.setTextFill(Color.GREEN);
    }

    private void goToDonorPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donor-view.fxml"));
            Parent root = loader.load();

            DonorController controller = loader.getController();
            controller.setUser(currentUser);

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
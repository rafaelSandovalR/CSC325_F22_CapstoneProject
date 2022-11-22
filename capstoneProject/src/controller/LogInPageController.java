package controller;

import app.Main;
import java.io.IOException;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Officer;
import model.StoreAndBackUpData;

public class LogInPageController {

    private String badgeN;
    private TreeMap<String, Officer> officerAccounts = StoreAndBackUpData.getOfficerAccounts();

    @FXML
    private Button backBtn;

    @FXML
    private Button logInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private Label titleLabel;

    @FXML
    private Label badgeNLabel;

    @FXML
    private TextField badgeNumberField;

    @FXML
    void goBackToHomePage(ActionEvent event) throws IOException {
        Main.setRoot("/view/HomePageView.fxml");
    }

    @FXML
    void logInMethod(ActionEvent event) throws IOException {
        badgeN = badgeNumberField.getText();
        if (badgeN.length() == 0) {
            badgeNLabel.setText("Enter your badge number");
        } else {
            System.err.println("called");
            if (!officerAccounts.containsKey(badgeN)) {
                badgeNLabel.setText("Badge number not found");
            } else {
                Main.setRoot("/view/LoggedInView.fxml");
            }

        }
    }

    @FXML
    void signUpMethod(ActionEvent event) throws IOException {
        Main.setRoot("/view/SignUpView.fxml");
    }

}

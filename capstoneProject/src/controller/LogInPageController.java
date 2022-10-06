package controller;

import java.io.IOException;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Officer;
import model.StoreAndBackUpData;

public class LogInPageController {

    private String badgeN;
    private TreeMap<String, Officer> officerAccounts = StoreAndBackUpData.getOfficerAccounts();

    @FXML
    private Label badgeNLabel;

    @FXML
    private TextField badgeNumberField;

    @FXML
    void goBackToHomePage(ActionEvent event) throws IOException {
        changeScene(event, "/view/HomePageView.fxml");
    }

    @FXML
    void logInMethod(ActionEvent event) throws IOException {

        if (badgeN.isBlank()) {
            badgeNLabel.setText("Enter your badge number");
        } else {
            if (!officerAccounts.containsKey(badgeNumberField.getText())) {
                badgeNLabel.setText("Badge number not found");
            }else{
                changeScene(event, "/view/LoggedInView.fxml");
            }

        }
    }
    
    public void changeScene(ActionEvent event, String str) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(str));
        Parent root = loader.load();
        Scene scene = new Scene(root, 700, 700);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setWidth(700);
        window.setHeight(700);
        window.setScene(scene);
        window.show();
    }
}

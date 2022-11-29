package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.finalproject.App;
import model.Officer;
import model.StoreAndBackUpData;

public class LogInPageController implements Initializable {

    public static String badgeN;
    private TreeMap<String, Officer> officerAccounts = StoreAndBackUpData.getOfficerAccounts();

    @FXML
    private ImageView imageview;
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
        App.setRoot("HomePageView.fxml");
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
                App.setRoot("LoggedInView.fxml");
            }

        }
    }

    @FXML
    void signUpMethod(ActionEvent event) throws IOException {
        App.setRoot("SignUpView.fxml");
    }


    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("file:image.png", 645, 650, false, false);
        imageview.setImage(image);
        imageview.setFitHeight(645);
        imageview.setFitWidth(650);
    }
}

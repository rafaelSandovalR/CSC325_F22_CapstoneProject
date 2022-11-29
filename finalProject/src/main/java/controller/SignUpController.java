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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.finalproject.App;
import model.Officer;
import model.StoreAndBackUpData;

public class SignUpController implements Initializable {

    private String fName;
    private String lName;
    private TreeMap<String, Officer> officerAccounts = StoreAndBackUpData.getOfficerAccounts();
    private int dCode = 4651;

    @FXML
    private ImageView imageview;
    @FXML
    private Label confirmLabel;

    @FXML
    private TextField departmentCodeField;

    @FXML
    private Label departmentCodeLabel;
    @FXML
    private TextField badgeNumberField;

    @FXML
    private TextField fNameField;

    @FXML
    private TextField lNameField;

    @FXML
    private Label fNameLabel;

    @FXML
    private Label lNameLabel;

    @FXML
    private Button submitBtn;
    @FXML
    private Button backBtn;

    @FXML
    private Pane pane;

    @FXML
    void submitMethod(ActionEvent event) {
        fName = fNameField.getText();
        lName = lNameField.getText();

        if (fName.isBlank()) {
            fNameLabel.setText("Enter your first name");
            lNameLabel.setText("");
            departmentCodeLabel.setText("");
        } else {
            String type = "";
            for (int i = 0; i < fName.length(); i++) {
                char ch = fName.charAt(i);
                if (Character.isDigit(ch)) {
                    type = "digit";
                }
            }
            if (type.compareTo("digit") == 0) {
                fNameLabel.setText("Enter letters only");
                lNameLabel.setText("");
                departmentCodeLabel.setText("");
            } else {
                if (lName.isBlank()) {
                    lNameLabel.setText("Enter your last name");
                    fNameLabel.setText("");
                    departmentCodeLabel.setText("");
                } else {
                    for (int i = 0; i < lName.length(); i++) {
                        char ch = lName.charAt(i);
                        if (Character.isDigit(ch)) {
                            type = "digit";
                        }
                    }
                    if (type.compareTo("digit") == 0) {
                        lNameLabel.setText("Enter letters only");
                        fNameLabel.setText("");
                        departmentCodeLabel.setText("");
                    } else {
                        if (departmentCodeField.getText().isBlank()) {
                            departmentCodeLabel.setText("Enter your department code");
                            fNameLabel.setText("");
                            lNameLabel.setText("");
                        } else {
                            for (int i = 0; i < departmentCodeField.getText().length(); i++) {
                                char ch = departmentCodeField.getText().charAt(i);
                                if (Character.isLetter(ch)) {
                                    type = "letter";
                                    System.err.println(i + " " + ch);
                                }
                            }
                            if (type.compareTo("letter") == 0) {
                                departmentCodeLabel.setText("Enter digits only");
                                fNameLabel.setText("");
                                lNameLabel.setText("");
                            } else {
                                if (dCode == (Integer.parseInt(departmentCodeField.getText()))) {
                                    departmentCodeLabel.setText("");
                                    Officer officer = new Officer(fName, lName, rand());
                                    officerAccounts.put(officer.getBadgeN(), officer);
                                    badgeNumberField.setText("Badge Number: " + officer.getBadgeN());
                                    submitBtn.setDisable(true);
                                    confirmLabel.setVisible(true);
                                } else {
                                    departmentCodeLabel.setText("Department code does not match");
                                    fNameLabel.setText("");
                                    lNameLabel.setText("");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private String rand() {
        int counter = 0;
        String str = "";
        while (counter < 4) {
            int random = (int) (Math.random() * (10 + 1 - 0)) + 0;
            str = str + random;
            counter++;
        }
        if (StoreAndBackUpData.getOfficerAccounts().containsKey(str)) {
            return rand();
        } else {
            return str;
        }
    }

    @FXML
    void goBackToHomePage(ActionEvent event) throws IOException {
        App.setRoot("HomePageView.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        submitBtn.setDisable(false);
        confirmLabel.setVisible(false);
        Image image = new Image("file:image.png", 645, 650, false, false);
        imageview.setImage(image);
        imageview.setFitHeight(645);
        imageview.setFitWidth(650);
    }
}

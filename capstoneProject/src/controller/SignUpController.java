package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Officer;
import model.StoreAndBackUpData;

public class SignUpController implements Initializable {

    private String fName;
    private String lName;
    private TreeMap<String, Officer> officerAccounts = StoreAndBackUpData.getOfficerAccounts();

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
    private Pane pane;

    @FXML
    void submitMethod(ActionEvent event) {
        fName = fNameField.getText();
        lName = lNameField.getText();

        if (fName.isBlank()) {
            fNameLabel.setText("Enter your first name");
            lNameLabel.setText("");
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
            } else {
                if (lName.isBlank()) {
                    lNameLabel.setText("Enter your last name");
                    fNameLabel.setText("");
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
                    } else {
                        Officer officer = new Officer(fName, lName);
                        officerAccounts.put(officer.getBadgeN(), officer);
                        badgeNumberField.setText("Badge Number: " + officer.getBadgeN());
                        submitBtn.setDisable(true);
                            
                        }
                    }
                    {

                    }
                }
            }

        }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        submitBtn.setDisable(false);
    }
}

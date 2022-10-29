package controller;

import java.io.IOException;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Complaint;
import model.StoreAndBackUpData;
import model.Uniteable;

public class FileAComplaintController {

    private TreeMap<String, Complaint> complaints = StoreAndBackUpData.getComplaints();
    private String name;
    private String additionalEvidence;
    private String address;
    private String complaintDescription;
    private String date;
    private String location;
    private String signature;
    private String signatureDate;
    private String time;
    private String telephone;
    private String fName;
    private String lName;

    @FXML
    private Button backBtn;

    @FXML
    private TextArea additionalEvidenceLabel;

    @FXML
    private TextField addressField;

    @FXML
    private TextArea complaintDescriptionLabel;

    @FXML
    private TextField dateField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField signatureDateField;

    @FXML
    private TextField signatureField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField timeField;

    @FXML
    private Button submitBrn;

    @FXML
    void submit(ActionEvent event) {
        name = nameField.getText();
        address = addressField.getText();
        date = dateField.getText();
        time = timeField.getText();
        telephone = telephoneField.getText();
        signature = signatureField.getText();
        signatureDate = signatureDateField.getText();
        location = locationField.getText();
        complaintDescription = complaintDescriptionLabel.getText();
        additionalEvidence = additionalEvidenceLabel.getText();

        if (name.isBlank()) {
            System.err.println("called");
        } else {
            if (name.isBlank()) {
                String[] n = name.split(" ");
                fName = n[0];
                lName = n[1];
            } else {
                fName = name;
                lName = " ";
                if (address.isBlank()) {

                } else if (date.isBlank()) {

                } else if (telephone.isBlank()) {

                } else if (signature.isBlank()) {

                } else if (signatureDate.isBlank()) {

                } else if (location.isBlank()) {

                } else if (complaintDescription.isBlank()) {

                } else {
                    Alert a = new Alert(AlertType.NONE);
                    a.setAlertType(AlertType.CONFIRMATION);
                    a.setContentText("You have successfully submitted the complaint form!");
                    a.show();
                    Complaint c = new Complaint(fName, lName, address, telephone, date, time, location, additionalEvidence, complaintDescription);
                    StoreAndBackUpData.getComplaints().put(c.getComplaint_id(), c);
                    submitBrn.setVisible(false);
                }

            }
        }
    }

    @FXML
    void backToLoggedIn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/LoggedInView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 700, 700);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setWidth(700);
        window.setHeight(700);
        window.setScene(scene);
        window.show();
    }
}

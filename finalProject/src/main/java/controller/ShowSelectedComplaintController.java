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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.finalproject.App;
import model.Complaint;
import model.StoreAndBackUpData;
import model.Uniteable;

public class ShowSelectedComplaintController implements Initializable {

    private TreeMap<String, Complaint> complaints = StoreAndBackUpData.getComplaints();
    private Complaint complaint;

    @FXML
    private TextArea additionalEvidenceLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private TextArea complaintDescriptionLabel;
    @FXML
    private Button backBtn;
    @FXML
    private Label dateLabel;

    @FXML
    private Label locationOfComplaintLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label signatureDateLabel;

    @FXML
    private Label signatureLabel;

    @FXML
    private Label timeLabel;

    private void showComplaint() {
        complaint = ComplaintHistoryController.complaint;
        if (complaints.containsValue(complaint)) {
            nameLabel.setText(complaint.getComplainant_fName() + " " + complaint.getComplainant_lName());
            addressLabel.setText(complaint.getComplainant_address());
            dateLabel.setText(complaint.getDate_of_occurance());
            phoneLabel.setText(complaint.getComplainant_phone());
            signatureLabel.setText(complaint.getComplainant_fName() + " " + complaint.getComplainant_lName());
            signatureDateLabel.setText(complaint.getCreationDate());
            timeLabel.setText(complaint.getTime_of_occurance());
            additionalEvidenceLabel.setText(complaint.getAnyRecord());
            complaintDescriptionLabel.setText(complaint.getDescription());
            locationOfComplaintLabel.setText(complaint.getLocation_of_occurance());
        } else {
        }
    }

    @FXML
    void backToComplaintHistory(ActionEvent event) throws IOException {
        App.setRoot("ComplaintsHistoryView.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showComplaint();
    }
}

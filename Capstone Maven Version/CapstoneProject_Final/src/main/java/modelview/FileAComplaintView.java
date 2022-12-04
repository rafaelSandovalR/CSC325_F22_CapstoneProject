package modelview;

import com.mycompany.mvvmexample.App;
import viewmodel.FileAComplaintViewModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.mycompany.mvvmexample.FirestoreContext;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Criminal;
import models.Complaint;

public class FileAComplaintView {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField locationField;
    @FXML
    private TextArea complaintDescriptionLabel;

    @FXML
    private TextField additionalEvidenceLabel;

    @FXML
    private TextField signatureField;

    @FXML
    private TextField signatureDateField;

    @FXML
    private Button submitBrn;

    @FXML
    private Button readButton;

    @FXML
    private TextField outputField;
    private boolean key;
    private ObservableList<Complaint> listOfComplaint = FXCollections.observableArrayList();
    private Complaint complaint;

    public ObservableList<Complaint> getListOfComplaint() {
        return listOfComplaint;
    }

    @FXML
    private void goBackToLoggedIN(ActionEvent event) {

    }

    void initialize() {

        FileAComplaintViewModel FileAComplaintViewModel = new FileAComplaintViewModel();
        firstNameField.textProperty().bindBidirectional(FileAComplaintViewModel.fullNameProperty());
        lastNameField.textProperty().bindBidirectional(FileAComplaintViewModel.fullNameProperty());
        addressField.textProperty().bindBidirectional(FileAComplaintViewModel.addressProperty());
        telephoneField.textProperty().bindBidirectional(FileAComplaintViewModel.telephoneProperty());
        dateField.textProperty().bindBidirectional(FileAComplaintViewModel.complaintDateProperty());
        timeField.textProperty().bindBidirectional(FileAComplaintViewModel.complaintTimeProperty());
        locationField.textProperty().bindBidirectional(FileAComplaintViewModel.locationOfComplaintProperty());
        complaintDescriptionLabel.textProperty().bindBidirectional(FileAComplaintViewModel.complaintDescriptionProperty());
        additionalEvidenceLabel.textProperty().bindBidirectional(FileAComplaintViewModel.complaintTimeProperty());
        signatureField.textProperty().bindBidirectional(FileAComplaintViewModel.witnessDetalProperty());
        signatureDateField.textProperty().bindBidirectional(FileAComplaintViewModel.complainantSignatureProperty());

        submitBrn.disableProperty().bind(FileAComplaintViewModel.isWritePossibleProperty().not());
    }

    @FXML
    private void addRecord(ActionEvent event) {
        addData();
    }

    @FXML
    private void readRecord(ActionEvent event) {
        readFirebase();
    }

    /**
     * Method to clear the text field after adding data
     */
    public void clearTextField() {
        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        telephoneField.clear();
        dateField.clear();
        timeField.clear();
        locationField.clear();
        complaintDescriptionLabel.clear();
        additionalEvidenceLabel.clear();
        signatureField.clear();
        signatureDateField.clear();
    }

    public void addData() {

        DocumentReference docRef = App.fstore.collection("FileAComplain").document(UUID.randomUUID().toString());
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("firstName", firstNameField.getText());
        data.put("lastName", lastNameField.getText());
        data.put("address", addressField.getText());
        data.put("telephone", telephoneField.getText());
        data.put("complaintDate", dateField.getText());
        data.put("complaintTime", timeField.getText());
        data.put("locationOfComplaint", locationField.getText());
        data.put("complaintDescription", complaintDescriptionLabel.getText());
        data.put("witnessDetal", additionalEvidenceLabel.getText());
        data.put("complainantSignature", signatureField.getText());
        data.put("complaintSignDate", signatureDateField.getText());

        //  data.put("Age", Integer.parseInt(ageField.getText()));
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);

        clearTextField();
    }

    public boolean readFirebase() {
        key = false;

        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = App.fstore.collection("Reference").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            if (documents.size() > 0) {
                System.out.println("Outing....");
                for (QueryDocumentSnapshot document : documents) {
                    outputField.setText(outputField.getText() + "Firstname: " + document.getData().get("firstName")
                            + " , LastName: " + document.getData().get("lastName")
                            + " , Address: " + document.getData().get("address")
                            + " , Telephone: " + document.getData().get("telephone")
                            + " , Complaint Date: " + document.getData().get("complaintDate")
                            + " , Complaint Time:  " + document.getData().get("complaintTime")
                            + " , Location Of Complaint: " + document.getData().get("locationOfComplaint")
                            + " , Complaint Description: " + document.getData().get("complaintDescription")
                            + " , Witness Detal: " + document.getData().get("witnessDetal")
                            + " , Complainant Signature: " + document.getData().get("complainantSignature")
                            + " , Complaint Sign Date: \n" + document.getData().get("complaintSignDate"));
                    System.out.println(" ");
                    //  System.out.println(document.getfName() + " => " + document.getData().get("fName"));

                    complaint = new Complaint(String.valueOf(document.getData().get("firstname")),
                            document.getData().get("lastName").toString(),
                            document.getData().get("address").toString(),
                            document.getData().get("telephone").toString(),
                            document.getData().get("complaintDate").toString(),
                            document.getData().get("complaintTime").toString(),
                            document.getData().get("locationOfComplaint").toString(),
                            document.getData().get("complaintDescription").toString(),
                            document.getData().get("witnessDetal").toString(),
                            document.getData().get("complainantSignature").toString(),
                            document.getData().get("complaintSignDate").toString());

                    //Integer.parseInt(document.getData().get("Age").toString()));
                    listOfComplaint.add(complaint);
                }
            } else {
                System.out.println("No data");
            }
            key = true;

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        return key;
    }

}

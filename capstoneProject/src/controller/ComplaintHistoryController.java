package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Complaint;
import model.Officer;
import model.StoreAndBackUpData;
import model.Uniteable;

public class ComplaintHistoryController implements Initializable {

    private ObservableList<Complaint> list = FXCollections.observableArrayList();
    private TreeMap<String, Complaint> complaints = StoreAndBackUpData.getComplaints();
    public static Complaint complaint ;

    @FXML
    private TableColumn<Complaint, String> complaintColumn;

    @FXML
    private TableColumn<Complaint, String> creationDateColumn;

    @FXML
    private TableColumn<Complaint, String> fNameColumn;

    @FXML
    private TableColumn<Complaint, String> idColumn;

    @FXML
    private TableColumn<Complaint, String> lNameColumn;

    @FXML
    private  TableView<Complaint> tableView;

    @FXML
    private TableColumn<Integer, Integer> counter;
    @FXML
    private Label alertLabel;
    @FXML
    private Button showComplaintBtn;
    
    @FXML
    private Button backBtn;
    @FXML
    void backToLoggedInPage(ActionEvent event) throws IOException {
        changeScene(event, "/view/LoggedInView.fxml");
    }

    public void showComplaintList() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("complaint_id"));
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("complainant_fName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("complainant_lName"));
        creationDateColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        counter.setId("1");
        tableView.setItems(list);
       
    }

    @FXML
    void goToShowComplaint(ActionEvent event) throws IOException {
        complaint = (Complaint) tableView.getSelectionModel().getSelectedItem();
        if (tableView.getSelectionModel().getSelectedItem() == null) {
            alertLabel.setVisible(true);
        } else {
            changeScene(event, "/view/ShowSelectedComplaintView.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        list.add(complaints.entrySet());
        list.addAll(complaints.values());
        alertLabel.setVisible(false);
        showComplaintList();
    }
}

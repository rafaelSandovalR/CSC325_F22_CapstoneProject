package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Complaint;
import model.Officer;
import model.StoreAndBackUpData;

public class ViewComplaintHistoryController implements Initializable {

    private TreeMap<String, Complaint> complaints = StoreAndBackUpData.getComplaints();
//    private ObservableList<Complaint> complaintList = FXCollections
//            .observableArrayList(complaints.values());

    @FXML
    private ListView<Object> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.getItems().add(complaints.values());
    }

}

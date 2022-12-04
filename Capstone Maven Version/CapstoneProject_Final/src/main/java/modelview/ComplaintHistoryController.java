
package modelview;

import com.mycompany.mvvmexample.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Complaint;
import models.StoreAndBackUpData;


public class ComplaintHistoryController  implements Initializable  {

    private ObservableList<Complaint> list = FXCollections.observableArrayList();
    private TreeMap<String, Complaint> complaints = StoreAndBackUpData.getComplaints();
    public static Complaint complaint;

    @FXML
    private Button deleteBtn;
    @FXML
    private ImageView imageview;
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
    private TableView<Complaint> tableView;

    @FXML
    private TableColumn<Integer, Integer> counter;
    @FXML
    private Label alertLabel;
    @FXML
    private Button showComplaintBtn;

    @FXML
    private Button backBtn;

    @FXML
    void deleteComplaint(ActionEvent event) {
        Complaint c = (Complaint) tableView.getSelectionModel().getSelectedItem();
        if (c == null) {
            alertLabel.setVisible(true);
        } else {
            alertLabel.setVisible(true);
            if(complaints.values() == null){
                
            }else{
            complaints.remove(c.getComplaint_id());
            }
            ObservableList<Complaint> list2 = FXCollections.observableArrayList();
             list2.addAll(complaints.values());
            showComplaintList(list2);
        }
    }

    @FXML
    void backToLoggedInPage(ActionEvent event) throws IOException {
        App.setRoot("/view/LoggedInView.fxml");
    }

    public void showComplaintList(ObservableList<Complaint> list) {
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
            App.setRoot("/view/ShowSelectedComplaintView.fxml");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        list.add(complaints.entrySet());
        if(complaints.values() == null){
            
        }else{
        list.addAll(complaints.values());
        alertLabel.setVisible(false);
        showComplaintList(list);
        }
        Image image = new Image("/controller/image.png", 645, 650, false, false);
        imageview.setImage(image);
        imageview.setFitHeight(645);
        imageview.setFitWidth(650);
    }
}
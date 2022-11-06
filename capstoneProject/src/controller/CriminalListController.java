package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Criminal;
import model.StoreAndBackUpData;
import model.Uniteable;


public class CriminalListController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private TableView<Criminal> criminalTable;
    
    @FXML
    private TableColumn<Criminal, String> idColumn;
    
    @FXML
    private TableColumn<Criminal, String> fnameColumn;
    
    @FXML
    private TableColumn<Criminal, String> lnameColumn;
    
    @FXML
    private TableColumn<Criminal, String> dobColumn;
    
    @FXML
    private TableColumn<Criminal, String> sexColumn;
    
    
    private ObservableList<Criminal> list = FXCollections.observableArrayList();
    private TreeMap<String, Criminal> criminals = StoreAndBackUpData.getCriminals();
    public static Criminal criminal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.addAll(criminals.values());
        showCriminalList();
    }
    
    public void showCriminalList(){

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        fnameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getfName()));
        lnameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getlName()));
        sexColumn.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getSex()));   
        dobColumn.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getDate_of_birth()));
        criminalTable.setItems(list);
    }

    @FXML
    public void backButtonPress(ActionEvent event) throws IOException {
        changeScene(event, "/view/LoggedInView.fxml");
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

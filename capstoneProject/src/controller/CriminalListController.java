package controller;

import app.Main;
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
        Main.setRoot("/view/LoggedInView.fxml");
    }
    
    @FXML
    public void goToCriminalEditView(ActionEvent event) throws IOException {
        Main.setRoot("/view/CriminalEditView.fxml");
    }
      
    @FXML
    public void goToCriminalDetailView(ActionEvent event) throws IOException {
            
        criminal = (Criminal) criminalTable.getSelectionModel().getSelectedItem();
        if (criminalTable.getSelectionModel().getSelectedItem() == null) {
            //alertLabel.setVisible(true);
        } else {
            Main.setRoot("/view/CriminalDetailView.fxml");
        }
    }
    
    @FXML
    public void goToCriminalHistoryView(ActionEvent event) throws IOException {
        Main.setRoot("/view/CriminalHistoryView.fxml");
    }
    
}

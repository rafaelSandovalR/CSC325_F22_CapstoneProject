/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Criminal;
import model.StoreAndBackUpData;
import model.Uniteable;


public class CriminalHistoryController implements Initializable {

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
    private TableColumn<Criminal, String> ageColumn;
    
    @FXML
    private TableColumn<Criminal, String> sexColumn;
    
    @FXML
    private TableColumn<Criminal, String> raceColumn;
    
    @FXML
    private TableColumn<Criminal, String> hairColumn;
    
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
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
       // raceColumn.setCellValueFactory(new PropertyValueFactory<>("NA"));
       // hairColumn.setCellValueFactory(new PropertyValueFactory<>("NA"));     
        criminalTable.setItems(list);
    }

    @FXML
    private void backButtonPress(ActionEvent event) throws IOException {
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

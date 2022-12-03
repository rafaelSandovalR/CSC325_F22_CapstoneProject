/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Crime;
import model.StoreAndBackUpData;

/**
 * FXML Controller class
 *
 * @author Rsand
 */
public class CrimeHistoryViewController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button detailedViewButton;
    @FXML
    private Button historyButton;
    @FXML
    private TableView<Crime> crimeTable;
    @FXML
    private TableColumn<Crime, String> dateColumn;
    @FXML
    private TableColumn<Crime, String> locationColumn;
    @FXML
    private TableColumn<Crime, String> victimColumn;
    @FXML
    private TableColumn<Crime, String> descriptionColumn;
    @FXML
    private TableColumn<Crime, String> sentenceColumn;

    
    private ObservableList<Crime> list = FXCollections.observableArrayList();
    private TreeMap<String, Crime> crimes = StoreAndBackUpData.getCrimes();
    public static Crime crime;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.addAll(crimes.values());
        showCrimeList();
    }    
    
    public void showCrimeList(){
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate_of_occurance()));
        locationColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocation_of_occurance()));
        crimeTable.setItems(list);
    }

    @FXML
    private void backButtonPress(ActionEvent event) throws IOException{
        Main.setRoot("/view/CriminalListView.fxml");
    }
    
}

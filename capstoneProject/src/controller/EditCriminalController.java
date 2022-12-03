/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import app.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Criminal;

/**
 * FXML Controller class
 *
 * @author Rsand
 */
public class EditCriminalController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField MonthField;
    @FXML
    private TextField DayField;
    @FXML
    private TextField YearField;
    @FXML
    private TextField placeOfBirthField;
    @FXML
    private TextField StreetField;
    @FXML
    private TextField CityField;
    @FXML
    private ComboBox<?> stateComboBox;
    @FXML
    private TextField PostalCodeField;
    @FXML
    private RadioButton MaleRadio;
    @FXML
    private ToggleGroup sexChoice;
    @FXML
    private RadioButton FemaleRadio;
    @FXML
    private TextField feetField;
    @FXML
    private TextField inchesField;
    @FXML
    private TextField weightField;
    @FXML
    private ComboBox<?> raceComboBox;
    @FXML
    private ComboBox<?> ethnicityComboBox;
    @FXML
    private ComboBox<?> eyeColorComboBox;
    @FXML
    private ComboBox<?> hairColorComboBox;
    @FXML
    private Button saveButton;

    private Criminal criminal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        criminal = CriminalListController.criminal;
        firstNameField.setText(criminal.getfName());
        lastNameField.setText(criminal.getlName());
        
        

        MonthField.setText(criminal.getDate_of_birth().substring(0, 2));

        DayField.setText(criminal.getDate_of_birth().substring(3,5));

        YearField.setText(criminal.getDate_of_birth().substring(6));

        placeOfBirthField.setText(criminal.getPlace_of_birth());
        
        String[]address = criminal.getAddress().split(",");

        StreetField.setText(address[0]);

        CityField.setText(address[1]);

      //  stateComboBox;

        PostalCodeField.setText(address[3]);

       // MaleRadio =;

      //  sexChoice =;

      //  FemaleRadio =;

        String[] height = criminal.getHeight().split("' ");
        feetField.setText(height[0]);


        inchesField.setText(height[1].replace("\"", ""));

        weightField.setText(criminal.getWeight());

       // raceComboBox =;

      //  ethnicityComboBox =;

       // eyeColorComboBox =;

        //hairColorComboBox =;
    }

    @FXML
    private void backButtonPress(ActionEvent event) throws IOException {
        Main.setRoot("/view/CriminalDetailView.fxml");
    }

    @FXML
    private void saveButtonPress(ActionEvent event) throws IOException{
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import app.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Criminal;
import model.StoreAndBackUpData;

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
    private ComboBox<String> stateComboBox;
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
    private ComboBox<String> raceComboBox;
    @FXML
    private ComboBox<String> ethnicityComboBox;
    @FXML
    private ComboBox<String> eyeColorComboBox;
    @FXML
    private ComboBox<String> hairColorComboBox;
    @FXML
    private Button saveButton;

    private Criminal criminal;

    private ObservableList<String> stateList = FXCollections
            .observableArrayList("Alabama", "Alaska", "American Samoa", "Arizona",
                    "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                    "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii",
                    "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                    "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
                    "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska",
                    "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
                    "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                    "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
                    "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

    private ObservableList<String> raceList = FXCollections
            .observableArrayList("White", "Black or African American", "American Indian or Alaska Native",
                    "Asian", "Native Hawaiian or Other Pacific Islander", "Other");

    private ObservableList<String> ethnicityList = FXCollections
            .observableArrayList("Hispanic or Latino", "Not Hispanic or Latino");

    private ObservableList<String> eyeColorList = FXCollections
            .observableArrayList("Brown", "Blue", "Green", "Hazel", "Amber", "Gray");

    private ObservableList<String> hairColorList = FXCollections
            .observableArrayList("Black", "Blonde", "Brown", "Red", "White");

    private boolean firstNameFieldChanged, lastNameFieldChanged, monthFieldChanged, dayFieldChanged,
            yearFieldChanged, placeOfBirthFieldChanged, streetFieldChanged, cityFieldChanged, stateComboBoxChanged,
            postalCodeFieldChanged, sexChoiceChanged, feetFieldChanged, inchesFieldChanged, weightFieldChanged,
            raceComboBoxChanged, ethnicityComboBoxChanged, eyeColorComboBoxChanged, hairColorComboBoxChanged = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        criminal = CriminalListController.criminal;
        firstNameField.setText(criminal.getfName());
        lastNameField.setText(criminal.getlName());
        MonthField.setText(criminal.getDate_of_birth().substring(0, 2));
        DayField.setText(criminal.getDate_of_birth().substring(3, 5));
        YearField.setText(criminal.getDate_of_birth().substring(6));
        placeOfBirthField.setText(criminal.getPlace_of_birth());

        String[] address = criminal.getAddress().split(",");
        StreetField.setText(address[0]);
        CityField.setText(address[1]);

        stateComboBox.setItems(stateList);
        stateComboBox.setValue(address[2]);
        PostalCodeField.setText(address[3]);

        ToggleGroup sexChoice = new ToggleGroup();
        MaleRadio.setToggleGroup(sexChoice);
        FemaleRadio.setToggleGroup(sexChoice);

        if (criminal.getSex().equals("Male")) {
            sexChoice.selectToggle(MaleRadio);
        } else {
            sexChoice.selectToggle(FemaleRadio);
        }

        String[] height = criminal.getHeight().split("' ");
        feetField.setText(height[0]);
        inchesField.setText(height[1].replace("\"", ""));

        weightField.setText(criminal.getWeight());
        raceComboBox.setItems(raceList);
        raceComboBox.setValue(criminal.getRace());
        ethnicityComboBox.setItems(ethnicityList);
        ethnicityComboBox.setValue(criminal.getEthnicity());
        eyeColorComboBox.setItems(eyeColorList);
        eyeColorComboBox.setValue(criminal.getEyeColor());
        hairColorComboBox.setItems(hairColorList);
        hairColorComboBox.setValue(criminal.getHairColor());

        setListeners();
    }

    @FXML
    private void backButtonPress(ActionEvent event) throws IOException {
        Main.setRoot("/view/CriminalDetailView.fxml");
    }

    @FXML
    private void saveButtonPress(ActionEvent event) throws IOException {
        boolean[] changes = {firstNameFieldChanged, lastNameFieldChanged, monthFieldChanged, dayFieldChanged,
            yearFieldChanged, placeOfBirthFieldChanged, streetFieldChanged, cityFieldChanged, stateComboBoxChanged,
            postalCodeFieldChanged, sexChoiceChanged, feetFieldChanged, inchesFieldChanged, weightFieldChanged,
            raceComboBoxChanged, ethnicityComboBoxChanged, eyeColorComboBoxChanged, hairColorComboBoxChanged};

        for (boolean fieldChange : changes) {
            if (fieldChange == true) {
                saveChanges();
            }
        }

    }

    private void setListeners() {
        firstNameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                firstNameFieldChanged = true;
                System.out.println("First Name Changed");
            }
        });

        lastNameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                lastNameFieldChanged = true;
                System.out.println("Last Name Changed");
            }
        });

        MonthField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                monthFieldChanged = true;
                System.out.println("Month Changed");
            }
        });

        DayField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                dayFieldChanged = true;
                System.out.println("Day Changed");
            }
        });

        YearField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                yearFieldChanged = true;
                System.out.println("Year Changed");
            }
        });

        placeOfBirthField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                placeOfBirthFieldChanged = true;
                System.out.println("POB Changed");
            }
        });

        StreetField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                streetFieldChanged = true;
                System.out.println("Street Changed");
            }
        });

        CityField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cityFieldChanged = true;
                System.out.println("City Changed");
            }
        });

        //TODO: need to check this when clicking edit button
        /*
        stateComboBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });
         */
        PostalCodeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                postalCodeFieldChanged = true;
                System.out.println("Postal Code Changed");
            }
        });

        //TODO: need to check these when clicking edit button
        /*
        RadioButton MaleRadio
        .textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });
        

        ToggleGroup sexChoice
        .textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });

        RadioButton FemaleRadio
        .textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });
         */
        feetField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                feetFieldChanged = true;
                System.out.println("Feet Changed");
            }
        });

        inchesField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                inchesFieldChanged = true;
                System.out.println("Inches Changed");
            }
        });

        weightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                weightFieldChanged = true;
                System.out.println("Weight Changed");
            }
        });

        //TODO: need to check these when clicking edit button
        /*
        raceComboBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });

        ethnicityComboBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });

        eyeColorComboBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });

        hairColorComboBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text Changed");
            }
        });
         */
    }

    private void saveChanges() {
        criminal.setfName(firstNameField.getText());
        criminal.setlName(lastNameField.getText());
        
        /*
        dateOfBirth = MonthField.getText()
                + "/" + DayField.getText()
                + "/" + YearField.getText();
        placeOfBirth = placeOfBirthField.getText();
        address = StreetField.getText()
                + ", " + CityField.getText()
                + ", " + stateComboBox.getValue()
                + ", " + PostalCodeField.getText();

        ToggleGroup sexChoice = new ToggleGroup();

        MaleRadio.setToggleGroup(sexChoice);
        FemaleRadio.setToggleGroup(sexChoice);

        sex = ((RadioButton) sexChoice.getSelectedToggle()).getText();

        height = feetField.getText() + "' " + inchesField.getText() + "\"";
        weight = weightField.getText();
        race = raceComboBox.getValue();
        ethnicity = ethnicityComboBox.getValue();
        eyeColor = eyeColorComboBox.getValue();
        hairColor = hairColorComboBox.getValue();

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.CONFIRMATION);
        a.setContentText("You have successfully added a criminal!");
        a.show();
        Criminal c = new Criminal(firstName, lastName, dateOfBirth,
                placeOfBirth, address, sex, height, weight, race,
                ethnicity, eyeColor, hairColor);
*/
        StoreAndBackUpData.getCriminals().put(criminal.getId(), criminal);
        saveButton.setVisible(false);

        
        System.out.println(criminal.toString());
    }

}

package modelview;

import viewmodel.AddCriminalViewModel;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import models.Criminal;
import models.StoreAndBackUpData;

public class AddCriminalControllerView {

    String firstName;
    String lastName;
    String dateOfBirth; //merge textfields
    String placeOfBirth;
    String address; //merge textfields
    String sex; //handle radio buttons
    String height; //merge textfields
    String weight;
    String race;
    String ethnicity;
    String eyeColor;
    String hairColor;

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
    private Button returnButton;
    @FXML
    private Button addButton;

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
    
    private Criminal criminalToAdd;

    @FXML
    private void initialize() {
        criminalToAdd = new Criminal();
        stateComboBox.setItems(stateList);
        raceComboBox.setItems(raceList);
        ethnicityComboBox.setItems(ethnicityList);
        eyeColorComboBox.setItems(eyeColorList);
        hairColorComboBox.setItems(hairColorList);

        //Not sure if all of this is necessary
        AddCriminalViewModel AddCriminalViewModel = new AddCriminalViewModel();
        firstNameField.textProperty().bindBidirectional(AddCriminalViewModel.criminalFirstNameProperty());
        lastNameField.textProperty().bindBidirectional(AddCriminalViewModel.criminalLastNameProperty());
        MonthField.textProperty().bindBidirectional(AddCriminalViewModel.dayProperty());
        DayField.textProperty().bindBidirectional(AddCriminalViewModel.monthProperty());
        YearField.textProperty().bindBidirectional(AddCriminalViewModel.yearProperty());
        placeOfBirthField.textProperty().bindBidirectional(AddCriminalViewModel.placeOfBirthProperty());
        StreetField.textProperty().bindBidirectional(AddCriminalViewModel.streetProperty());
        CityField.textProperty().bindBidirectional(AddCriminalViewModel.cityProperty());
        stateComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.stateComboBoxProperty());
        feetField.textProperty().bindBidirectional(AddCriminalViewModel.feetProperty());
        inchesField.textProperty().bindBidirectional(AddCriminalViewModel.inchesProperty());
        weightField.textProperty().bindBidirectional(AddCriminalViewModel.weightProperty());
        raceComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.raceComboBoxProperty());
        ethnicityComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.ethnicityComboBoxProperty());
        eyeColorComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.eyeColorComboBoxProperty());
        hairColorComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.hairColorComboBoxProperty());
        addButton.disableProperty().bind(AddCriminalViewModel.isWritePossibleProperty().not());
    }

    @FXML
    private void addCriminal(ActionEvent event) {
        //Retrieve all input
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
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

        //Display Confirmation
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.CONFIRMATION);
        a.setContentText("You have successfully added a criminal!");
        a.show();
        
        //Create Instance of Criminal
        criminalToAdd = new Criminal(firstName, lastName, dateOfBirth,
                placeOfBirth, address, sex, height, weight, race,
                ethnicity, eyeColor, hairColor);
        
        //Save criminal in Firestore
        StoreAndBackUpData.addCriminal(criminalToAdd.getId(), criminalToAdd);
        System.out.println(criminalToAdd.toString());
    }

    @FXML
    void backToLoggedIn(ActionEvent event) throws IOException {
        App.setRoot("LoggedInView.fxml");
    }

}

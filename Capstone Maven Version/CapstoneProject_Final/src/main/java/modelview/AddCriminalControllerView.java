package modelview;

import viewmodel.AddCriminalViewModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import models.Criminal;
import models.StoreAndBackUpData;
import viewmodel.FileAComplaintViewModel;

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

    @FXML
    private void initialize() {

        stateComboBox.setItems(stateList);
        raceComboBox.setItems(raceList);
        ethnicityComboBox.setItems(ethnicityList);
        eyeColorComboBox.setItems(eyeColorList);
        hairColorComboBox.setItems(hairColorList);
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
        MaleRadio.textProperty().bindBidirectional(AddCriminalViewModel.maleRadioProperty());
        FemaleRadio.textProperty().bindBidirectional(AddCriminalViewModel.femaleRadioProperty());
        feetField.textProperty().bindBidirectional(AddCriminalViewModel.feetProperty());
        inchesField.textProperty().bindBidirectional(AddCriminalViewModel.inchesProperty());
        weightField.textProperty().bindBidirectional(AddCriminalViewModel.weightProperty());
        raceComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.raceComboBoxProperty());
        ethnicityComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.ethnicityComboBoxProperty());
        eyeColorComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.eyeColorComboBoxProperty());
        hairColorComboBox.valueProperty().bindBidirectional(AddCriminalViewModel.hairColorComboBoxProperty());
        addButton.disableProperty().bind(AddCriminalViewModel.isWritePossibleProperty().not());
    }

    public void addData() {

        DocumentReference docRef = App.fstore.collection("AddCriminal").document(UUID.randomUUID().toString());
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("firstName", firstNameField.getText());
        data.put("lastName", lastNameField.getText());
        data.put("month", MonthField.getText());
        data.put("day", DayField.getText());
        data.put("year", YearField.getText());
        data.put("placeOfBirth", placeOfBirthField.getText());
        data.put("street", StreetField.getText());
        data.put("city", CityField.getText());
        data.put("stateComboBox", stateComboBox.getValue());
        data.put("postalCode", PostalCodeField.getText());
        data.put("maleRadio", MaleRadio.getText());
        data.put("femaleRadio", FemaleRadio.getText());
        data.put("feet", feetField.getText());
        data.put("inches", inchesField.getText());
        data.put("weight", weightField.getText());
        data.put("raceComboBox", raceComboBox.getValue());
        data.put("ethnicityComboBox", ethnicityComboBox.getValue());
        data.put("eyeColorComboBox", eyeColorComboBox.getValue());
        data.put("hairColorComboBox", hairColorComboBox.getValue());

        //  data.put("Age", Integer.parseInt(ageField.getText()));
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);

        // clearTextField();
    }

    @FXML
    private void addCriminal(ActionEvent event) {

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

        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.CONFIRMATION);
        a.setContentText("You have successfully added a criminal!");
        a.show();
        Criminal c = new Criminal(firstName, lastName, dateOfBirth,
                placeOfBirth, address, sex, height, weight, race,
                ethnicity, eyeColor, hairColor);
        StoreAndBackUpData.getCriminals().put(c.getId(), c);
        addButton.setVisible(false);

        System.out.println(c.toString());
    }

    @FXML
    void backToLoggedIn(ActionEvent event) throws IOException {
        //Main.setRoot("/view/LoggedInView.fxml");

    }

}

package viewmodel;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddCriminalViewModel {
    
    private final StringProperty criminalFirstName = new SimpleStringProperty();
    private final StringProperty criminalLastName = new SimpleStringProperty();
    private final StringProperty day = new SimpleStringProperty();
    private final StringProperty month = new SimpleStringProperty();
    private final StringProperty year = new SimpleStringProperty();
    private final StringProperty placeOfBirth = new SimpleStringProperty();
    private final StringProperty street = new SimpleStringProperty();
    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty stateComboBox = new SimpleStringProperty(); // do I change this one to not String Property?
    private final StringProperty postalCode = new SimpleStringProperty();
    private final StringProperty maleRadio = new SimpleStringProperty();
    private final StringProperty femaleRadio = new SimpleStringProperty();
    private final StringProperty feet = new SimpleStringProperty();
    private final StringProperty inches = new SimpleStringProperty();
    private final StringProperty weight = new SimpleStringProperty();
    private final StringProperty raceComboBox = new SimpleStringProperty();
    private final StringProperty ethnicityComboBox = new SimpleStringProperty();
    private final StringProperty eyeColorComboBox = new SimpleStringProperty();
    private final StringProperty hairColorComboBox = new SimpleStringProperty();

    private final ReadOnlyBooleanWrapper writePossible = new ReadOnlyBooleanWrapper();

    public AddCriminalViewModel() {
        writePossible.bind(criminalFirstName.isNotEmpty().and(criminalLastName.isNotEmpty()));
    }

    public StringProperty criminalFirstNameProperty() {
        return criminalFirstName;
    }

    public StringProperty criminalLastNameProperty() {
        return criminalLastName;
    }

    public StringProperty dayProperty() {
        return day;
    }
     public StringProperty monthProperty() {
        return month;
    }

    public StringProperty yearProperty() {
        return year;
    }

    public StringProperty placeOfBirthProperty() {
        return placeOfBirth;
    }

    public StringProperty streetProperty() {
        return street;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public StringProperty stateComboBoxProperty() {
        return stateComboBox;  // stateComboBox.getSelectItem().toString();
    }

    public StringProperty cpostalCodeProperty() {
        return postalCode;
    }

    public StringProperty maleRadioProperty() {
        return maleRadio;
    }

    public StringProperty femaleRadioProperty() {
        return femaleRadio;
    }

    public StringProperty feetProperty() {
        return feet;
    }

    public StringProperty inchesProperty() {
        return inches;
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public StringProperty raceComboBoxProperty() {
        return raceComboBox;
    }

    public StringProperty ethnicityComboBoxProperty() {
        return ethnicityComboBox;
    }

    public StringProperty eyeColorComboBoxProperty() {
        return eyeColorComboBox;
    }

    public StringProperty hairColorComboBoxProperty() {
        return hairColorComboBox;
    }

    public ReadOnlyBooleanProperty isWritePossibleProperty() {
        return writePossible.getReadOnlyProperty();
    }

}

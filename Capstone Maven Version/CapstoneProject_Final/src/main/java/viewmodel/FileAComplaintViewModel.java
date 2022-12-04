 package viewmodel;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileAComplaintViewModel {
    
    private final StringProperty ComplaintFullName = new SimpleStringProperty();
    private final StringProperty ComplaintAddress = new SimpleStringProperty();
    private final StringProperty ComplaintTelephone = new SimpleStringProperty();
    private final StringProperty ComplaintDate = new SimpleStringProperty();
    private final StringProperty ComplaintTime = new SimpleStringProperty();
    private final StringProperty locationOfComplaint = new SimpleStringProperty();
    private final StringProperty complaintDescription = new SimpleStringProperty();
    private final StringProperty witnessDetal = new SimpleStringProperty();
    private final StringProperty complainantSignature = new SimpleStringProperty();
    private final StringProperty complaintSignDate = new SimpleStringProperty();

    private final ReadOnlyBooleanWrapper writePossible = new ReadOnlyBooleanWrapper();

    public FileAComplaintViewModel() {
        writePossible.bind(ComplaintFullName.isNotEmpty().and(ComplaintTelephone.isNotEmpty()));
    }

    public StringProperty fullNameProperty() {
        return ComplaintFullName;
    }

    public StringProperty addressProperty() {
        return ComplaintAddress;
    }

    public StringProperty telephoneProperty() {
        return ComplaintTelephone;
    }

    public StringProperty complaintDateProperty() {
        return ComplaintDate;
    }

    public StringProperty complaintTimeProperty() {
        return ComplaintTime;
    }

    public StringProperty locationOfComplaintProperty() {
        return locationOfComplaint;
    }

    public StringProperty complaintDescriptionProperty() {
        return complaintDescription;
    }

    public StringProperty witnessDetalProperty() {
        return witnessDetal;
    }

    public StringProperty complainantSignatureProperty() {
        return complainantSignature;
    }

    public StringProperty complaintSignDateProperty() {
        return complaintSignDate;
    }

    public ReadOnlyBooleanProperty isWritePossibleProperty() {
        return writePossible.getReadOnlyProperty();
    }
}

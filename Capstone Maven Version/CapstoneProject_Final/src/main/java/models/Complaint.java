package models;

public class Complaint {

    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private String complaintDate;
    private String complaintTime;
    private String locationOfComplaint;
    private String complaintDescription;
    private String witnessDetal;
    private String complainantSignature;
    private String complaintSignDate;
    private String complaint_id;

    public Complaint(String firstName, String lastName, String address, String telephone, String complaintDate, String complaintTime, String locationOfComplaint, String complaintDescription, String witnessDetal,
            String complainantSignature, String complaintSignDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
        this.complaintDate = complaintDate;
        this.complaintTime = complaintTime;
        this.locationOfComplaint = locationOfComplaint;
        this.complaintDescription = complaintDescription;
        this.witnessDetal = witnessDetal;
        this.complainantSignature = complainantSignature;
        this.complaintSignDate = complaintSignDate;
        this.complaint_id = rand();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(String complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(String complaintTime) {
        this.complaintTime = complaintTime;
    }

    public String getLocationOfComplaint() {
        return locationOfComplaint;
    }

    public void setLocationOfComplaint(String locationOfComplaint) {
        this.locationOfComplaint = locationOfComplaint;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getWitnessDetal() {
        return witnessDetal;
    }

    public void setWitnessDetal(String witnessDetal) {
        this.witnessDetal = witnessDetal;
    }

    public String getComplainantSignature() {
        return complainantSignature;
    }

    public void setComplainantSignature(String complainantSignature) {
        this.complainantSignature = complainantSignature;
    }

    public String getComplaintSignDate() {
        return complaintSignDate;
    }

    public void setComplaintSignDate(String complaintSignDate) {
        this.complaintSignDate = complaintSignDate;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    private String rand() {
        String str = "";
        for (int i = 0; i < 4; i++) {
            str = str + (int) (Math.random() * (10 + 1 - 0)) + 0;
        }
        return str;
    }

}

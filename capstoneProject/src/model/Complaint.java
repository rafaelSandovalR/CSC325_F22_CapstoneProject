package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Complaint implements Uniteable {

    private String complainant_fName;
    private String complainant_lName;
    private String complainant_address;
//    private String complainant_dob;
//    private String complainant_sex;
    private String complainant_phone;
//    private String police_name;
//    private String badge_number;
//    private String witness_name;
//    private String witness_address;
//    private String witness_phone;
    private String date_of_occurance;
    private String time_of_occurance;
    private String location_of_occurance;
    private String anyRecord;
    private String complaint_id;
    private String creationDate;
    private String creationTime;
    private String description;

    public Complaint(String complainant_fName, String complainant_lName, String complainant_address, String complainant_phone, String date_of_occurance, String time_of_occurance, String location_of_occurance, String anyRecord, String description) {
        this.complainant_fName = complainant_fName;
        this.complainant_lName = complainant_lName;
        this.complainant_address = complainant_address;
//        this.complainant_dob = complainant_dob;
//        this.complainant_sex = complainant_sex;
        this.complainant_phone = complainant_phone;
//        this.police_name = police_name;
//        this.badge_number = badge_number;
//        this.witness_name = witness_name;
//        this.witness_address = witness_address;
//        this.witness_phone = witness_phone;
        this.description = description;
        this.date_of_occurance = date_of_occurance;
        this.time_of_occurance = time_of_occurance;
        this.location_of_occurance = location_of_occurance;
        this.anyRecord = anyRecord;
        this.complaint_id = rand();
        this.creationDate = getCreationDate1();
//        this.creationTime = getCreationTime();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

//    private String getCreationTime() {
//        Date date = Calendar.getInstance().getTime();
//        DateFormat formatter = new SimpleDateFormat("EEEE, hh:mm:ss.SSS a");
//        String time = formatter.format(date);
//        return time;
//    }

    private String getCreationDate1() {
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
//        formatter = new SimpleDateFormat("EEEE, hh:mm:ss.SSS a");
//        String time = formatter.format(date);
        return (today);
    }

    public String getComplaint_id() {
        return complaint_id;
    }

//    public String getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCurrentDate(String date) {
//        this.creationDate = date;
//    }
//    
//    public String getComplaint_Id(){
//        return complaint_id;
//    }
//    
//    public void setComplaint_Id(String str){
//        this.complaint_id = str;
//    }
    public String getCreationDate() {
        return creationDate;
    }

    private String rand() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + (int)(Math.random() * (10 + 1 - 0)) + 0;
        }
        return str;
    }

    public String getComplainant_fName() {
        return complainant_fName;
    }

    public String getComplainant_lName() {
        return complainant_lName;
    }

    public String getComplainant_address() {
        return complainant_address;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

//    public String getComplainant_dob() {
//        return complainant_dob;
//    }
//
//    public String getComplainant_sex() {
//        return complainant_sex;
//    }

    public String getComplainant_phone() {
        return complainant_phone;
    }

//    public String getPolice_name() {
//        return police_name;
//    }
//
//    public String getBadge_number() {
//        return badge_number;
//    }
//
//    public String getWitness_name() {
//        return witness_name;
//    }
//
//    public String getWitness_address() {
//        return witness_address;
//    }
//
//    public String getWitness_phone() {
//        return witness_phone;
//    }

    public String getDate_of_occurance() {
        return date_of_occurance;
    }

    public String getTime_of_occurance() {
        return time_of_occurance;
    }

    public String getLocation_of_occurance() {
        return location_of_occurance;
    }

    public String getAnyRecord() {
        return anyRecord;
    }

    public void setComplainant_fName(String complainant_fName) {
        this.complainant_fName = complainant_fName;
    }

    public void setComplainant_lName(String complainant_lName) {
        this.complainant_lName = complainant_lName;
    }

    public void setComplainant_address(String complainant_address) {
        this.complainant_address = complainant_address;
    }

//    public void setComplainant_dob(String complainant_dob) {
//        this.complainant_dob = complainant_dob;
//    }
//
//    public void setComplainant_sex(String complainant_sex) {
//        this.complainant_sex = complainant_sex;
//    }

    public void setComplainant_phone(String complainant_phone) {
        this.complainant_phone = complainant_phone;
    }

//    public void setPolice_name(String police_name) {
//        this.police_name = police_name;
//    }
//
//    public void setBadge_number(String badge_number) {
//        this.badge_number = badge_number;
//    }
//
//    public void setWitness_name(String witness_name) {
//        this.witness_name = witness_name;
//    }
//
//    public void setWitness_address(String witness_address) {
//        this.witness_address = witness_address;
//    }

//    public void setWitness_phone(String witness_phone) {
//        this.witness_phone = witness_phone;
//    }

    public void setDate_of_occurance(String date_of_occurance) {
        this.date_of_occurance = date_of_occurance;
    }

    public void setTime_of_occurance(String time_of_occurance) {
        this.time_of_occurance = time_of_occurance;
    }

    public void setLocation_of_occurance(String location_of_occurance) {
        this.location_of_occurance = location_of_occurance;
    }

    public void setAnyRecord(String summary_of_complaint) {
        this.anyRecord = summary_of_complaint;
    }

    @Override
    public String toString() {
        return "Complaint{" + "complainant_fName=" + complainant_fName + ", complainant_lName=" + complainant_lName + "coomplaint id: " + complaint_id +"creationDate: " + creationDate + ", complainant_address="
                + complainant_address + ", complainant_phone="
                + complainant_phone + ", date_of_occurance=" + date_of_occurance + ", time_of_occurance=" + time_of_occurance + ", location_of_occurance=" + location_of_occurance + ", summary_of_complaint=" + anyRecord + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rsand
 */
public class Crime {

    private String crime_id;
    private Criminal criminal;
    private String victim_fName;
    private String victim_lName;
    private String victim_dob;
    private String victim_sex;
    private String victim_phone;
    private String victim_address;
//    private String police_name;
//    private String badge_number;
//    private String witness_name;
//    private String witness_address;
//    private String witness_phone;
    private String date_of_occurance;
    private String time_of_occurance;
    private String location_of_occurance;

    private String creationDate;
    private String creationTime;
    private String description;
    private String sentence;

    public Crime(Criminal criminal, String victim_fName, String victim_lName, 
            String victim_dob, String victim_sex, String victim_phone, String victim_address, 
            String date_of_occurance, String time_of_occurance, String location_of_occurance, 
            String description, String sentence) {
        this.crime_id = rand();
        this.criminal = criminal;
        this.victim_fName = victim_fName;
        this.victim_lName = victim_lName;
        this.victim_dob = victim_dob;
        this.victim_sex = victim_sex;
        this.victim_phone = victim_phone;
        this.victim_address = victim_address;
//        this.police_name = police_name;
//        this.badge_number = badge_number;
//        this.witness_name = witness_name;
//        this.witness_address = witness_address;
//        this.witness_phone = witness_phone;
        this.date_of_occurance = date_of_occurance;
        this.time_of_occurance = time_of_occurance;
        this.location_of_occurance = location_of_occurance;
        this.creationDate = new Date().toString();
        this.description = description;
        this.sentence = sentence;
    }

    public String getCrime_id() {
        return crime_id;
    }

    public Criminal getCriminal() {
        return criminal;
    }

    public void setCriminal(Criminal criminal) {
        this.criminal = criminal;
    }

    public String getVictim_fName() {
        return victim_fName;
    }

    public void setVictim_fName(String victim_fName) {
        this.victim_fName = victim_fName;
    }

    public String getVictim_lName() {
        return victim_lName;
    }

    public void setVictim_lName(String victim_lName) {
        this.victim_lName = victim_lName;
    }

    public String getVictim_dob() {
        return victim_dob;
    }

    public void setVictim_dob(String victim_dob) {
        this.victim_dob = victim_dob;
    }

    public String getVictim_sex() {
        return victim_sex;
    }

    public void setVictim_sex(String victim_sex) {
        this.victim_sex = victim_sex;
    }

    public String getVictim_phone() {
        return victim_phone;
    }

    public void setVictim_phone(String victim_phone) {
        this.victim_phone = victim_phone;
    }

    public String getVictim_address() {
        return victim_address;
    }

    public void setVictim_address(String victim_address) {
        this.victim_address = victim_address;
    }

    public String getDate_of_occurance() {
        return date_of_occurance;
    }

    public void setDate_of_occurance(String date_of_occurance) {
        this.date_of_occurance = date_of_occurance;
    }

    public String getTime_of_occurance() {
        return time_of_occurance;
    }

    public void setTime_of_occurance(String time_of_occurance) {
        this.time_of_occurance = time_of_occurance;
    }

    public String getLocation_of_occurance() {
        return location_of_occurance;
    }

    public void setLocation_of_occurance(String location_of_occurance) {
        this.location_of_occurance = location_of_occurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    private String rand() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + (int) (Math.random() * (10 + 1 - 0)) + 0;
        }
        return str;
    }

    @Override
    public String toString() {
        return "Crime{" + "crime_id=" + crime_id + ", criminal=" + criminal + ", victim_fName=" + victim_fName + ", victim_lName=" + victim_lName + ", victim_dob=" + victim_dob + ", victim_sex=" + victim_sex + ", victim_phone=" + victim_phone + ", victim_address=" + victim_address + ", date_of_occurance=" + date_of_occurance + ", time_of_occurance=" + time_of_occurance + ", location_of_occurance=" + location_of_occurance + ", creationDate=" + creationDate + ", creationTime=" + creationTime + ", description=" + description + '}';
    }

    
}

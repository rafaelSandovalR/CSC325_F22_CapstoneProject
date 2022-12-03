package model;

import java.util.TreeMap;

public class StoreAndBackUpData {

    private static TreeMap<String, Officer> officerAccounts;
    private static TreeMap<String, Criminal> criminals;
    private static TreeMap<String, Complaint> complaintsHistory;
    private static TreeMap<String, Crime> crimes;

    public StoreAndBackUpData() {
        officerAccounts = new TreeMap<>();
        criminals = new TreeMap<>();
        complaintsHistory = new TreeMap<>();
        crimes = new TreeMap<>();
    }

    public void addComplaint(String id, Complaint complaint){
        complaintsHistory.put(id, complaint);
    }
    
    public static TreeMap<String, Complaint> getComplaints(){
        return complaintsHistory;
    }
    public void addOfficer(String badgeN, Officer user) {
        officerAccounts.put(badgeN, user);
    }

    public static TreeMap<String, Officer> getOfficerAccounts() {
        return officerAccounts;
    }
    

    public void addCriminal(String id, Criminal criminal) {
        criminals.put(id, criminal);
    }

    public static TreeMap<String, Criminal> getCriminals() {
        return criminals;
    }
    
    public void addCrime(String id, Crime crime){
        crimes.put(id, crime);
    }
    
    public static TreeMap<String, Crime> getCrimes(){
        return crimes;
    }
}

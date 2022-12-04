package models;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.mycompany.mvvmexample.App;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class StoreAndBackUpData {

    private static TreeMap<String, Officer> officerAccounts;
    private static TreeMap<String, Criminal> criminals;
    private static TreeMap<String, Complaint> complaintsHistory;

    public StoreAndBackUpData() {
        officerAccounts = new TreeMap<>();
        criminals = new TreeMap<>();
        complaintsHistory = new TreeMap<>();
    }
    
  

    public void addComplaint(String id, Complaint complaint) {
        complaintsHistory.put(id, complaint);
    }

    public static TreeMap<String, Complaint> getComplaints() {
        return complaintsHistory;
    }

    public static void addOfficer(String badgeN, Officer user) {
        officerAccounts.put(badgeN, user);
    }

    public static TreeMap<String, Officer> getOfficerAccounts() {
        return officerAccounts;
    }

    public static void addCriminal(String id, Criminal criminal) {
        criminals.put(id, criminal);
        
        DocumentReference docRef = App.fstore.collection("AddCriminal").document(UUID.randomUUID().toString());
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("firstName", criminal.getfName());
        data.put("lastName", criminal.getlName());
        data.put("dateOfBirth", criminal.getDate_of_birth());
        data.put("placeOfBirth", criminal.getPlace_of_birth());
        data.put("address", criminal.getAddress());
        data.put("sex", criminal.getSex());
        data.put("height", criminal.getHeight());
        data.put("weight", criminal.getWeight());
        data.put("race", criminal.getRace());
        data.put("ethnicity", criminal.getEthnicity());
        data.put("eyeColor", criminal.getEyeColor());
        data.put("hairColor", criminal.getHairColor());

        //  data.put("Age", Integer.parseInt(ageField.getText()));
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);

        // clearTextField();
    }

    public static TreeMap<String, Criminal> getCriminals() {
        return criminals;
    }
}


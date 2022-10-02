package model;

import java.util.TreeMap;

public class StoreAndBackUpData {

    private static TreeMap<String, Officer> officerAccounts;
    private static TreeMap<String, Criminal> criminals;

    public StoreAndBackUpData() {
        officerAccounts = new TreeMap<>();
        criminals = new TreeMap<>();
    }

    public void addOfficer(String badgeN, Officer user) {
        officerAccounts.put(badgeN, user);
    }

    public static TreeMap<String, Officer> getOfficerAccounts() {
        return officerAccounts;
    }
    

    public void addCriminal(String id, Criminal user) {
        criminals.put(id, user);
    }

    public static TreeMap<String, Criminal> getCriminals() {
        return criminals;
    }
}

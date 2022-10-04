package model;

public class Officer {

    private String fName;
    private String lName;
    private String badgeN;

    public Officer(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.badgeN = rand();
    }

    private String rand() {
        int counter = 0;
        String str = "";
        while (counter < 7) {
            int random = (int) (Math.random() * (10 + 1 - 0)) + 0;
            str = str + random;
            counter++;
        }
        if (StoreAndBackUpData.getOfficerAccounts().containsKey(str)) {
            return rand();
        }else{
            return str;
        }
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getBadgeN() {
        return badgeN;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Employee{" + "fName=" + fName + ", lName=" + lName + ", badgeN=" + badgeN + '}';
    }
}

package model;

public class Officer {
    
    private String fName;
    private String lName;
    private String id;

    public Officer(String fName, String lName, String id) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }
    

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getId() {
        return id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Employee{" + "fName=" + fName + ", lName=" + lName + ", id=" + id + '}';
    }
}

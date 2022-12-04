package models;

public class Criminal {

    private final String id;
    private String fName;
    private String lName;
    private String date_of_birth;
    private String place_of_birth;
    private String address;
    private String sex;
    private String height;
    private String weight;
    private String race;
    private String ethnicity;
    private String eyeColor;
    private String hairColor;
    
    

    public Criminal(String fName, String lName, String date_of_birth, String place_of_birth, String address, String sex, String height, String weight, String race, String ethnicity, String eyeColor, String hairColor) {
        this.fName = fName;
        this.lName = lName;
        this.date_of_birth = date_of_birth;
        this.place_of_birth = place_of_birth;
        this.address = address;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.race = race;
        this.ethnicity = ethnicity;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.id = rand();
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
    
    public String getId(){
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return "Criminal{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", date_of_birth=" + date_of_birth + ", place_of_birth=" + place_of_birth + ", address=" + address + ", sex=" + sex + ", height=" + height + ", weight=" + weight + ", race=" + race + ", ethnicity=" + ethnicity + ", eyeColor=" + eyeColor + ", hairColor=" + hairColor + '}';
    }
    
}
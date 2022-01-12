package tech.getarrays.petmanager.viewModel;

public class PetViewModel {

    //@JsonIgnore
    private String id;

    private String breed;

    //@JsonIgnore
    private String gender;

    //    @JsonIgnore
    private String date;

    private String serialn;
    //    @JsonIgnore
    private String record;

    private String PetCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSerialn() {
        return serialn;
    }

    public void setSerialn(String serialn) {
        this.serialn = serialn;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getPetCode() {
        return PetCode;
    }

    public void setPetCode(String petCode) {
        PetCode = petCode;
    }

    //    public String getUserCode() {
//        return UserCode;
//    }
//
//    public void setUserCode(String userCode) {
//        UserCode = userCode;
//    }
}

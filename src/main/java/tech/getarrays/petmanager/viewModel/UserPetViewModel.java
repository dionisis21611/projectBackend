package tech.getarrays.petmanager.viewModel;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class UserPetViewModel {
    private String id;

    private String name;

    private String email;

    private String username;

    private String password;

    private String phone;

    private HashMap<String , HashSet<Date[]>> pets;

    public UserPetViewModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, HashSet<Date[]>> getPets() {
        return pets;
    }

    public void setPets(HashMap<String, HashSet<Date[]>> pets) {
        this.pets = pets;
    }
}

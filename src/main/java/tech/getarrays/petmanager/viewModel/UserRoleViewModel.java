package tech.getarrays.petmanager.viewModel;

import com.sun.istack.NotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class UserRoleViewModel {
    private String id;

    private String name;

    private String email;

    private String username;

    private String password;

    private String phone;

    private HashMap<String , HashSet<Date[]>> roles;
    private String city;

    public  UserRoleViewModel(){

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

    public HashMap<String, HashSet<Date[]>> getRoles() {
        return roles;
    }

    public void setRoles(HashMap<String, HashSet<Date[]>> roles) {
        this.roles = roles;
    }

    public String getCity() { return city;}

    public void setCity(String city) {
        this.city = city;
    }
}

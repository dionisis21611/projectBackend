package tech.getarrays.petmanager.viewModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class UserViewModel {

    //@JsonIgnore
    private String id;

    private String name;

    //@JsonIgnore
    private String email;

    //    @JsonIgnore
    private String username;

    private String password;
    //    @JsonIgnore
    private String phone;

//    private String UserCode;

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


//    public String getUserCode() {
//        return UserCode;
//    }
//
//    public void setUserCode(String userCode) {
//        UserCode = userCode;
//    }
}

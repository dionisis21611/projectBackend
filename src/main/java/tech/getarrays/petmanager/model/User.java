package tech.getarrays.petmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class User implements Serializable {
    @Id
    @Column(nullable = false)
    private String id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String city;

    public User() {}

//    public User(String name, String email, String username, String password, String phone) {
//        this.name = name;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.phone = phone;
//
//    }
    public User(String name, String username, String email, String password, String phone, String city) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.city = city;
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

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() { return city; }

    public void setCity(String city) {
        this.city = city;
    }


}

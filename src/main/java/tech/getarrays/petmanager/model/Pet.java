package tech.getarrays.petmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String breed;
    private String gender;
    private String date;
    private String serialn;
    private String record;
    @Column(nullable = false, updatable = false)
    private String petCode;
    private boolean accept;
    @JsonIgnore
    @OneToMany(mappedBy = "pet")
    private Set<UserPet> UserPets = new HashSet<>();

    public Pet() {}

    public Pet(String breed, String gender, String date, String serialn, String record, String petCode, boolean accept) {
        this.breed = breed;
        this.gender = gender;
        this.date = date;
        this.serialn = serialn;
        this.record = record;
        this.petCode = petCode;
        this.accept = accept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                ", serialn='" + serialn + '\'' +
                ", record='" + record + '\'' +
                ", accept='" + accept + '\'' +
                '}';
    }
}

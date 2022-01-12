package tech.getarrays.petmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalId;
import org.springframework.web.bind.annotation.CrossOrigin;
import tech.getarrays.petmanager.Side.RoleName;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "petmannager_roles")
@CrossOrigin
public class Role implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private RoleName name;


    @Column(nullable = false, updatable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Set<UserRole> UserRoles = new HashSet<>();

    protected Role() {
        this.id = UUID.randomUUID().toString();
        //     this.users = new ArrayList<>();
    }
    public Role(RoleName name, String description) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }
//    public Role(String id, RoleName name, String description) {
//        if (id != null) {
//            this.id = id;
//        } else {
//            this.id = UUID.randomUUID().toString();
//        }
//        this.name = name;
//        this.description = description;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserRole> getUserRoles() {
        return UserRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        UserRoles = userRoles;
    }
}

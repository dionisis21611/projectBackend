package tech.getarrays.petmanager.viewModel;

import com.sun.istack.NotNull;

public class RoleViewModel {
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

//    private int nbUsers;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getNbUsers() {
//        return nbUsers;
//    }
//
//    public void setNbUsers(int nbUsers) {
//        this.nbUsers = nbUsers;
    //}
}

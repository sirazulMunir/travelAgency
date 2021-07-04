package com.bs.travelagency.dto;

public class UserSetupDTO {

    //region for private variables
    private Long id;
    private String name;
    private String email;
    //endregion


    //region for getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    //endregion

}

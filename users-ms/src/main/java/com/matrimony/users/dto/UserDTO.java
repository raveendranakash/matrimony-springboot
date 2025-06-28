package com.matrimony.users.dto;

import java.time.LocalDateTime;

public class UserDTO {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean isPremiumUser;
    private LocalDateTime createdTime;

    public UserDTO(Long id, String fName, String mName, String lName, boolean isPremiumUser){
        this.id=id;
        this.firstName=fName;
        this.middleName=mName;
        this.lastName=lName;
        this.isPremiumUser=isPremiumUser;
        this.createdTime=LocalDateTime.now();
    }

    public UserDTO(String fName, String mName, String lName, boolean isPremiumUser){
        this.firstName=fName;
        this.middleName=mName;
        this.lastName=lName;
        this.isPremiumUser=isPremiumUser;
        this.createdTime=LocalDateTime.now();
    }

    public UserDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isPremiumUser() {
        return isPremiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        isPremiumUser = premiumUser;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}

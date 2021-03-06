package com.example.medicheck;

import java.io.Serializable;

public class UserAccount implements Serializable {

    private String userName;
    private String userType;

    private boolean active;

    public UserAccount(String userName)  {
        this.userName= userName;
        this.userType = userType;
        this.active= true;
    }

    public UserAccount(String userName, boolean active)  {
        this.userName= userName;
        this.active= active;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.userName;
    }

}
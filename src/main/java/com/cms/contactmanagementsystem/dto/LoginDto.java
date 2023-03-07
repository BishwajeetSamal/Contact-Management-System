package com.cms.contactmanagementsystem.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginDto {
    @NotNull(message = "User Name required")
    @NotEmpty(message = "User Name required")
    private String userName;
    private String userPassword;

    public LoginDto(@NotNull(message = "User Name required") @NotEmpty(message = "User Name required") String userName,
                    String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public LoginDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "LoginDto [userName=" + userName + ", userPassword=" + userPassword + "]";
    }



}


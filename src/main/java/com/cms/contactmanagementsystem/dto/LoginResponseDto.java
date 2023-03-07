package com.cms.contactmanagementsystem.dto;

public class LoginResponseDto {
    private String UserName;
    private String organisation;
    private String token;

    public LoginResponseDto(String userName, String organisation, String token) {
        UserName = userName;
        this.organisation = organisation;
        this.token = token;
    }

    public LoginResponseDto() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponseDto [UserName=" + UserName + ", organisation=" + organisation + ", token=" + token + "]";
    }

}


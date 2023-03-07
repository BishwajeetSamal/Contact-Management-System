package com.cms.contactmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RegisterDto {
    private long id;

    @NotNull(message = "User Name required")
    @NotEmpty(message = "User Name required")
    private String userName;

    @NotNull(message = "Password required")
    @NotEmpty(message = "Password required")
    private String userPassword;

    @NotNull(message = "Enter first name")
    @NotEmpty(message = "Enter first name")
    private String firstName;

    @NotNull(message = "Enter last name")
    @NotEmpty(message = "Enter last name")
    private String lastName;

    @NotNull(message = "Contact phone required")
    @NotEmpty(message = "Contact phone required")
    private String contactNo;

    @Email(message = "Valid email id required")
    @NotNull(message = "Enter email Id")
    @NotEmpty(message = "Enter email Id")
    private String emailId;

    @NotNull(message = "Enter organisation")
    @NotEmpty(message = "Enter organisation")
    private String organisation;

    @NotNull(message = "Enter dob")
    @NotEmpty(message = "Enter dob")
    private String dob;

    public RegisterDto(long id,
                       @NotNull(message = "User Name required") @NotEmpty(message = "User Name required") String userName,
                       @NotNull(message = "Password required") @NotEmpty(message = "Password required") String userPassword,
                       @NotNull(message = "Enter first name") @NotEmpty(message = "Enter first name") String firstName,
                       @NotNull(message = "Enter last name") @NotEmpty(message = "Enter last name") String lastName,
                       @NotNull(message = "Contact phone required") @NotEmpty(message = "Contact phone required") String contactNo,
                       @Email(message = "Valid email id required") @NotNull(message = "Enter email Id") @NotEmpty(message = "Enter email Id") String emailId,
                       @NotNull(message = "Enter organisation") @NotEmpty(message = "Enter organisation") String organisation,
                       @NotNull(message = "Enter dob") @NotEmpty(message = "Enter dob") String dob) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.organisation = organisation;
        this.dob = dob;
    }

    public RegisterDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "RegisterDto [contactNo=" + contactNo + ", dob=" + dob + ", emailId=" + emailId + ", firstName="
                + firstName + ", id=" + id + ", lastName=" + lastName + ", organisation=" + organisation + ", userName="
                + userName + ", userPassword=" + userPassword + "]";
    }

}


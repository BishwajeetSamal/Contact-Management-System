package com.cms.contactmanagementsystem.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ContactDto {

    private Long id;
    @NotNull(message = "First Name required")
    @NotEmpty(message = "First Name required")
    private String firstName;
    @NotNull(message = "Last Name required")
    @NotEmpty(message = "Last Name required")
    private String lastName;
    @NotNull(message = "Email required")
    @NotEmpty(message = "Email required")
    private String email;
    @NotNull(message = "Mobile Number required")
    @NotEmpty(message = "Mobile Number required")
    private String phone_number;

    public ContactDto(Long id, String firstName, String lastName, String email, String phone_number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}

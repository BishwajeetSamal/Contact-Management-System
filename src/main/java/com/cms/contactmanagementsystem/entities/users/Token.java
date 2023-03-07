package com.cms.contactmanagementsystem.entities.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Token {
    @Id
    @GeneratedValue(generator = "token_generator")
    @SequenceGenerator(name = "token_generator", sequenceName = "token_sequence", initialValue = 1)
    private long id;

    private long userId;

    private String userToken;

    public Token() {
    }

    public Token(long id, long userId, String userToken) {
        this.id = id;
        this.userId = userId;
        this.userToken = userToken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @Override
    public String toString() {
        return "Token [id=" + id + ", userId=" + userId + ", userToken=" + userToken + "]";
    }

}


package com.ss.example.springsecuritystarter.Models.DTOs;

import com.ss.example.springsecuritystarter.Security.Validators.PasswordMatches;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String passwordMatching;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMatching() {
        return passwordMatching;
    }

    public void setPasswordMatching(String passwordMatching) {
        this.passwordMatching = passwordMatching;
    }
}

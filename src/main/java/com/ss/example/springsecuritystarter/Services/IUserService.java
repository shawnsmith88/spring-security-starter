package com.ss.example.springsecuritystarter.Services;


import com.ss.example.springsecuritystarter.Exceptions.UsernameExistsException;
import com.ss.example.springsecuritystarter.Models.DTOs.UserDto;
import com.ss.example.springsecuritystarter.Models.User;

public interface IUserService {
    public User registerNewUserAccount(UserDto userDto) throws UsernameExistsException;
}

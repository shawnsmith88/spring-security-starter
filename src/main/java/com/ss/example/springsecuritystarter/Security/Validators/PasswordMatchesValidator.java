package com.ss.example.springsecuritystarter.Security.Validators;


import com.ss.example.springsecuritystarter.Models.DTOs.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDto> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context){
        UserDto user = userDto;
        return user.getPassword().equals(user.getPasswordMatching());
    }
}

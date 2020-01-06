package com.myproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FirstnameValidator implements
        ConstraintValidator<Firstname, String> {

    @Override
    public void initialize(Firstname firstname) {
    }

    @Override
    public boolean isValid(String name,
                           ConstraintValidatorContext cxt) {
        return name != null &&  name.matches("^[A-Za-z]+")
                && (name.length() > 2) && (name.length() < 45);
    }

}
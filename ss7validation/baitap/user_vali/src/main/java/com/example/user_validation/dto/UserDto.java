package com.example.user_validation.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserDto implements Validator {
    private int id;

    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;


    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank
    private String phoneNumber;


    @Min(18)
    private int age;


    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;


    public UserDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phone = userDto.getPhoneNumber();
        if (phone.length() > 11 || phone.length() < 10) {
            errors.rejectValue("phoneNumber", "number.length", "so co 10 chu so");
        }
        if (!phone.startsWith("0")) {
            errors.rejectValue("phoneNumber", "number.startsWith", "phai bat dau bang 0");
        }
        if (!phone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "number.matches", "phai nhap so");
        }
    }
}

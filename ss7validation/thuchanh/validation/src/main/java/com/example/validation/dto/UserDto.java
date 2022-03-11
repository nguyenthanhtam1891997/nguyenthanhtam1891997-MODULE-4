package com.example.validation.dto;

import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto  {
    @NotEmpty(message = "ten khong duoc de trong")
    @Size(min = 2,max = 30,message = "do dai phai trong khoan 2 den 30")
    private String name;

    @Min(value = 18,message = "phai tren 18")
    private int age;

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

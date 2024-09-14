package com.example.lab1_calcularor.entities;

import java.io.Serializable;

public class UserData implements Serializable {
    private String phone;
    private String name;
    private String surname;

    public UserData(String phone, String name, String surname) {
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

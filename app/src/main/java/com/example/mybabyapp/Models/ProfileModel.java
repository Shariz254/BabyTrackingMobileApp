package com.example.mybabyapp.Models;

public class ProfileModel {

    public String babyName;
    public String babyDob;
    public String babyGender;

    public ProfileModel(String babyName, String babyDob, String babyGender) {
        this.babyName = babyName;
        this.babyDob = babyDob;
        this.babyGender = babyGender;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getBabyDob() {
        return babyDob;
    }

    public void setBabyDob(String babyDob) {
        this.babyDob = babyDob;
    }

    public String getBabyGender() {
        return babyGender;
    }

    public void setBabyGender(String babyGender) {
        this.babyGender = babyGender;
    }
}

package com.example.mybabyapp.Models;

public class BathModel {

    public String bathTime;
    public String bathDay;

    public BathModel(String bathTime, String bathDay) {
        this.bathTime = bathTime;
        this.bathDay = bathDay;
    }

    public String getBathTime() {
        return bathTime;
    }

    public void setBathTime(String bathTime) {
        this.bathTime = bathTime;
    }

    public String getBathDay() {
        return bathDay;
    }

    public void setBathDay(String bathDay) {
        this.bathDay = bathDay;
    }
}

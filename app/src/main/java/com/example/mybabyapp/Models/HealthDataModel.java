package com.example.mybabyapp.Models;

public class HealthDataModel {
    public String babyWeight;
    public String babyHeight;

    public HealthDataModel(String babyWeight, String babyHeight) {
        this.babyWeight = babyWeight;
        this.babyHeight = babyHeight;
    }

    public String getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(String babyWeight) {
        this.babyWeight = babyWeight;
    }

    public String getBabyHeight() {
        return babyHeight;
    }

    public void setBabyHeight(String babyHeight) {
        this.babyHeight = babyHeight;
    }
}

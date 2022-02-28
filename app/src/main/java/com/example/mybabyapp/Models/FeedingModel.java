package com.example.mybabyapp.Models;

public class FeedingModel {
    public String feeding_Time;
    public String food_Type;
    public String food_Quantity;

    public FeedingModel(String feeding_Time, String food_Type, String food_Quantity) {
        this.feeding_Time = feeding_Time;
        this.food_Type = food_Type;
        this.food_Quantity = food_Quantity;
    }

    public String getFeeding_Time() {
        return feeding_Time;
    }

    public void setFeeding_Time(String feeding_Time) {
        this.feeding_Time = feeding_Time;
    }

    public String getFood_Type() {
        return food_Type;
    }

    public void setFood_Type(String food_Type) {
        this.food_Type = food_Type;
    }

    public String getFood_Quantity() {
        return food_Quantity;
    }

    public void setFood_Quantity(String food_Quantity) {
        this.food_Quantity = food_Quantity;
    }
}

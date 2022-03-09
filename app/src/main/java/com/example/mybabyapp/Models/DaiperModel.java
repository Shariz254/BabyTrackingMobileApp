package com.example.mybabyapp.Models;

public class DaiperModel {
    public String change_time;
    public String changeDay;

    public DaiperModel(String change_time, String changeDay) {
        this.change_time = change_time;
        this.changeDay = changeDay;
    }

    public String getChange_time() {
        return change_time;
    }

    public void setChange_time(String change_time) {
        this.change_time = change_time;
    }

    public String getChangeDay() {
        return changeDay;
    }

    public void setChangeDay(String changeDay) {
        this.changeDay = changeDay;
    }
}

package com.example.mybabyapp.Models;

public class SleepModel {
    public String sleep_time;
    public String wakeUp_time;

    public SleepModel(String sleep_time, String wakeUp_time) {
        this.sleep_time = sleep_time;
        this.wakeUp_time = wakeUp_time;
    }

    public String getSleep_time() {
        return sleep_time;
    }

    public void setSleep_time(String sleep_time) {
        this.sleep_time = sleep_time;
    }

    public String getWakeUp_time() {
        return wakeUp_time;
    }

    public void setWakeUp_time(String wakeUp_time) {
        this.wakeUp_time = wakeUp_time;
    }
}

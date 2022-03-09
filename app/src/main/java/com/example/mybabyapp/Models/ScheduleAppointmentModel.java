package com.example.mybabyapp.Models;

public class ScheduleAppointmentModel {
    public String babyName;
    public String babyAge;
    public String babySymptoms;
    public String timeFrom;
    public String dayFrom;

    public ScheduleAppointmentModel(String babyName, String babyAge, String babySymptoms, String timeFrom, String dayFrom) {
        this.babyName = babyName;
        this.babyAge = babyAge;
        this.babySymptoms = babySymptoms;
        this.timeFrom = timeFrom;
        this.dayFrom = dayFrom;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(String babyAge) {
        this.babyAge = babyAge;
    }

    public String getBabySymptoms() {
        return babySymptoms;
    }

    public void setBabySymptoms(String babySymptoms) {
        this.babySymptoms = babySymptoms;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getDayFrom() {
        return dayFrom;
    }

    public void setDayFrom(String dayFrom) {
        this.dayFrom = dayFrom;
    }
}

package com.example.calenderview;

public class events {
    String Event, Time, Date, Month, Year;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public events(String event, String time, String date, String month, String year) {
        Event = event;
        Time = time;
        Date = date;
        Month = month;
        Year = year;
    }
}

package com.pokorili.musicOn.entity;


public class DaillyMenu {

    private long id;


    private String day;


    private Meal breakfast;



    public long getId() {
        return id;
    }


    public String getDay() {
        return day;
    }


    public void setDay(String day) {
        this.day = day;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Meal getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Meal breakfast) {
        this.breakfast = breakfast;
    }
}

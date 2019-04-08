package com.pokorili.musicOn.entity;

public class DaillyMenuWeekRateInstance {

    private Long id;


    private DaillyMenu menu;

    private WeeklyDiet week;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DaillyMenu getMenu() {
        return menu;
    }

    public void setMenu(DaillyMenu menu) {
        this.menu = menu;
    }


    public WeeklyDiet getWeek() {
        return week;
    }

    public void setWeek(WeeklyDiet week) {
        this.week = week;
    }
}

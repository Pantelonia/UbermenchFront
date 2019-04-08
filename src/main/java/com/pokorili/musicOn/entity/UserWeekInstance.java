package com.pokorili.musicOn.entity;


public class UserWeekInstance {

    private Long id;


    private Users user;

    private WeeklyDiet week;


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeeklyDiet getWeek() {
        return week;
    }

    public void setWeek(WeeklyDiet week) {
        this.week = week;
    }
}

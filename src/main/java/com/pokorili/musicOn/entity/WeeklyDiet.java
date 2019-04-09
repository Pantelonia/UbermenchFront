package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public class WeeklyDiet {

    private long id;


    private String name;


    private String description;

    private String author;


    @JsonIgnore
    private Collection<DaillyMenuWeekRateInstance> daillyMenuWeekRateInstances;


    @JsonIgnore
    private Collection<UserWeekInstance> userWeekInstances;

    WeeklyDiet(){};
    WeeklyDiet(String name, String description, String author){
        this.name = name;
        this.description = description;
        this.author = author;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

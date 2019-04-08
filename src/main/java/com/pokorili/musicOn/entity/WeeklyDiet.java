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

}

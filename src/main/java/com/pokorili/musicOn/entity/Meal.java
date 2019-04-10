package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public class Meal {

    private long id;


    @JsonIgnore
    private Collection<DaillyMenu> breakfasts;


    @JsonIgnore
    private Collection<Meal> meals;

    public Meal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Collection<DaillyMenu> getBreakfasts() {
        return breakfasts;
    }

    public void setBreakfasts(Collection<DaillyMenu> breakfasts) {
        this.breakfasts = breakfasts;
    }

    public Collection<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Collection<Meal> meals) {
        this.meals = meals;
    }
}



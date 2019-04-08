package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public class Meal {

    private long id;


    @JsonIgnore
    private Collection<DaillyMenu> breakfasts;


    @JsonIgnore
    private Collection<Dish> dish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Collection<Dish> getDish() {
        return dish;
    }

    public void setDish(Collection<Dish> dish) {
        this.dish = dish;
    }
}



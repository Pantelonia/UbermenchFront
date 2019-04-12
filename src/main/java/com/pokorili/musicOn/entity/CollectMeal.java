package com.pokorili.musicOn.entity;

import javax.persistence.*;

@Entity
public class CollectMeal {

    private long id;


    private Meal meal;


    private Dish dish;

    public CollectMeal(){

    }

    public Meal getMeal() {
        return meal;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}

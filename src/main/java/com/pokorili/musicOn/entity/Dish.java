package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



public class Dish {

    private long id;


    private String name;


    private float kkal;


    private float protein;


    private float carbohydrates;


    private float fat;


    private String description;


    private String type_dish;


    private Meal meal;

    public Dish() {
    }

    public Dish(Long id, String name, float kkal, float protein, float carbohydrates, float fat, String description, String type_dish) {
        this.id = id;
        this.name = name;
        this.kkal = kkal;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.description = description;
        this.type_dish = type_dish;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getKkal() {
        return kkal;
    }

    public void setKkal(float kkal) {
        this.kkal = kkal;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_dish() {
        return type_dish;
    }

    public void setType_dish(String type_dish) {
        this.type_dish = type_dish;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}

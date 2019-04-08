package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false, updatable = false)
    private long id;

    @Basic
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Basic
    @Column(name = "kkal")
    private float kkal;

    @Basic
    @Column(name = "protein")
    private float protein;

    @Basic
    @Column(name = "carbohydrates")
    private float carbohydrates;

    @Basic
    @Column(name = "fat")
    private float fat;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "type_dish")
    private String type_dish;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "meal",  referencedColumnName = "id", nullable = false)
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

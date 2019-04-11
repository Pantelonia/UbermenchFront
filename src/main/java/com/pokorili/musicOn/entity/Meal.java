package com.pokorili.musicOn.entity;





public class Meal
{

    private long id;


    private String name;


    private DaillyMenu menu;



    public Meal(){

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

    public DaillyMenu getMenu() {
        return menu;
    }

    public void setMenu(DaillyMenu menu) {
        this.menu = menu;
    }


}

package com.pokorili.musicOn.entity;

import java.sql.Date;



public class Parametrs {

    private long id;


    private Date date;


    private int height;

    private int weight;


    private int age;


    private char gender;

    private Users users;

    public  Parametrs(long id, Date date, int height, int weight, int age, char gender, Users user){
        this.id = id;
        this.date =date;
        this.height= height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.users = user;

    }
    public  Parametrs(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

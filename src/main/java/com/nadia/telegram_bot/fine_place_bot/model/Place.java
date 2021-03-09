package com.nadia.telegram_bot.fine_place_bot.model;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    private int id;

    @Column(name = "place_name")
    private String name;

    @Column(name= "city")//необходимо ли это здесь?
    private String city;

    public Place(){}

    public Place(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Place(String name, String city){
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

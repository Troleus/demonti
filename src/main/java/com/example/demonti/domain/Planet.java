package com.example.demonti.domain;

/**
 * Данная работа является тестовой
 */

import javax.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String planetName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "over_lord_id")
    private Lord overLord;


    public Planet() {
    }

    public Planet(String name) {
        this.planetName = name;
    }

    public Lord getOverLord() {
        return overLord;
    }

    public void setOverLord(Lord overLord) {
        this.overLord = overLord;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return planetName;
    }

    public void setName(String name) {
        this.planetName = name;
    }
}

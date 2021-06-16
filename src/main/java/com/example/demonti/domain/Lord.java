package com.example.demonti.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lords")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lordName;
    private Integer age;

    @OneToMany(mappedBy = "overLord", fetch = FetchType.EAGER)
    private List<Planet> planetList;

    public Lord() {
    }

    public Lord(String lordName, Integer age) {
        this.lordName = lordName;
        this.age = age;
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }

    public void setPlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLordName() {
        return lordName;
    }

    public void setLordName(String lordName) {
        this.lordName = lordName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

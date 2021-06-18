package com.example.demonti.service;

import com.example.demonti.domain.Planet;

import java.util.Optional;

public interface PlanetService {
    Planet addPlanet(Planet planet);

    void delete(long id);

    Iterable<Planet> findAll();

    Optional<Planet> findById(Long planetid);

    void update(Planet planet);
}

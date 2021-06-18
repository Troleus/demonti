package com.example.demonti.repos;

import com.example.demonti.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepos extends JpaRepository<Planet, Long> {

}

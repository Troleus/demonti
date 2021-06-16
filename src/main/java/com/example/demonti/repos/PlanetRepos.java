package com.example.demonti.repos;

import com.example.demonti.domain.Lord;
import com.example.demonti.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanetRepos extends JpaRepository<Planet, Long> {

}

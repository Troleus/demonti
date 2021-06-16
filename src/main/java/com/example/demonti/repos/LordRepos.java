package com.example.demonti.repos;

import com.example.demonti.domain.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface LordRepos extends JpaRepository<Lord, Long>{

        List<Lord> findByOrderByAge();

        @Query("SELECT l FROM Lord l LEFT JOIN l.planetList p WHERE p.overLord IS NULL")
        List<Lord> getLordsAllWithoutPlanet();
}

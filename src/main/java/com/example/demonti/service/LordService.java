package com.example.demonti.service;

import com.example.demonti.domain.Lord;

import java.util.List;
import java.util.Optional;

public interface LordService {

    Lord addLord(Lord lord);
    List<Lord> getLordsAllWithoutPlanet();
    List<Lord> getTop10YangLords();
    List<Lord> findAll();

    Optional<Lord> findById(Long lordid);
}

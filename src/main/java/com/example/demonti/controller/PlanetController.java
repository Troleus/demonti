package com.example.demonti.controller;

/**
 * Данная работа является тестовой
 */

import com.example.demonti.domain.Lord;
import com.example.demonti.domain.Planet;
import com.example.demonti.service.LordService;
import com.example.demonti.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private LordService lordService;

    @GetMapping("/planets")
    public String planets(Map<String, Object> model) {
        Iterable<Planet> planets = planetService.findAll();
        model.put("planets", planets);
        model.put("error", "");
        model.put("errorplanet", "");
        return "planets";
    }

    @PostMapping("/planets")
    public String addPlanets(@RequestParam String name, Map<String, Object> model) {
        if (name != null && !name.isEmpty()) {
            planetService.addPlanet(new Planet(name));
            model.put("error", "");
        } else {
            model.put("error", "имя не может быть пустым");
        }
        model.put("errorplanet", "");
        Iterable<Planet> planets = planetService.findAll();
        model.put("planets", planets);
        return "planets";
    }

    @PostMapping("delete")
    public String deletePlan(Long delete, Map<String, Object> model) {
        planetService.delete(delete);

        Iterable<Planet> planets = planetService.findAll();
        model.put("error", "");
        model.put("errorplanet", "");
        model.put("planets", planets);
        return "planets";
    }

    @PostMapping("addlord")
    public String addLordById(Long lordid, Long planetid, Map<String, Object> model) {
        Optional<Lord> byId = lordService.findById(lordid);
        if (!byId.isPresent()) {
            model.put("error", "");
            model.put("errorplanet", "Такого повелителя не существует");
            return "planets";
        }
        Optional<Planet> byPlanet = planetService.findById(planetid);
        if (!byPlanet.isPresent()) {
            model.put("error", "");
            model.put("errorplanet", "Такой планеты не существует");
            return "planets";
        }
        Lord lord = byId.get();
        Planet planet = byPlanet.get();
        planet.setOverLord(lord);
        planetService.update(planet);
        model.put("error", "");
        Iterable<Planet> planets = planetService.findAll();
        model.put("planets", planets);
        model.put("errorplanet", "");
        return "planets";
    }
}

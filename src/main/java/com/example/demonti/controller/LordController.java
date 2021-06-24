package com.example.demonti.controller;

/**
 * Данная работа является тестовой
 */

import com.example.demonti.domain.Lord;
import com.example.demonti.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class LordController {
    @Autowired
    private LordService lordService;

    @GetMapping("/lords")
    public String lords(Map<String, Object> model) {
        Iterable<Lord> lords = lordService.findAll();
        model.put("lords", lords);
        return "lords";
    }

    @PostMapping("/lords")
    public String addLords(@RequestParam String name, @RequestParam Integer age, Map<String, Object> model) {
        lordService.addLord(new Lord(name, age));

        Iterable<Lord> lords = lordService.findAll();
        model.put("lords", lords);
        return "lords";
    }

    @GetMapping("top")
    public String topLord(Map<String, Object> model) {
        List<Lord> tops = lordService.getTop10YangLords();
        model.put("lords", tops);
        return "lords";
    }

    @GetMapping("noplan")
    public String noPlanLord(Map<String, Object> model) {
        List<Lord> tops = lordService.getLordsAllWithoutPlanet();
        model.put("lords", tops);
        return "lords";
    }
}

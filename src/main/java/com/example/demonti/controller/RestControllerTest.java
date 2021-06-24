package com.example.demonti.controller;

import com.example.demonti.domain.Lord;
import com.example.demonti.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerTest {

    @Autowired
    private LordService lordService;

    @GetMapping("/lordsget")
    public List<Lord> getL(){
        return lordService.findAll();
    }
}

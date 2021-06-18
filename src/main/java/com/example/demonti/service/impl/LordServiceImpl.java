package com.example.demonti.service.impl;

import com.example.demonti.domain.Lord;
import com.example.demonti.repos.LordRepos;
import com.example.demonti.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LordServiceImpl implements LordService {

    @Autowired
    private LordRepos lordRepos;

    @Override
    public Lord addLord(Lord lord) {
        return lordRepos.saveAndFlush(lord);
    }

    @Override
    public List<Lord> getLordsAllWithoutPlanet() {
        return lordRepos.getLordsAllWithoutPlanet();
    }


    @Override
    public List<Lord> getTop10YangLords() {
        List<Lord> top = lordRepos.findByOrderByAge();
        if (top.size() > 10) {
            return top.subList(0, 10);
        }
        return top;
    }

    @Override
    public List<Lord> findAll() {
        return lordRepos.findAll();
    }

    @Override
    public Optional<Lord> findById(Long lordid) {
        return lordRepos.findById(lordid);
    }
}

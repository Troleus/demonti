package com.example.demonti;

import com.example.demonti.domain.Lord;
import com.example.demonti.domain.Planet;
import com.example.demonti.repos.LordRepos;
import com.example.demonti.service.LordService;
import com.example.demonti.service.impl.LordServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LordServiceImplTest {

    private LordRepos lordRepos = mock(LordRepos.class);
    private LordService lordService = new LordServiceImpl(lordRepos);

    @Test
    public void shouldGetAllLords(){
        List<Lord> lord = new ArrayList<>();
        lord.add(new Lord("lor", 23));
        Mockito.when(lordRepos.findAll()).thenReturn(lord);

        List<Lord> lords = lordService.findAll();

        assertEquals(lords.size(), 1);
        assertEquals(lords.get(0).getLordName(), "lor");
        assertEquals(lords.get(0).getAge(), 23);
    }

    @Test
    public void shouldGetTop10YangLords(){
        List<Lord> lord = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            lord.add(new Lord("lord", i + 1));
        }
        Mockito.when(lordRepos.findAll()).thenReturn(lord);

        List<Lord> lords = lordService.getTop10YangLords();

        assertEquals(lords.size(), 10);
    }

    @Test
    public void shouldGetLordsAllWithoutPlanet(){
        List<Lord> lord = new ArrayList<>();
        List<Planet> planetList = Arrays.asList(new Planet("f34g"), new Planet("h56"));
        lord.add(new Lord("a", 12));
        lord.add(new Lord("b", 45));
        lord.add(new Lord("c", 467));
        lord.add(new Lord("d", 121));
        lord.add(new Lord("f", 345));
        lord.get(0).setPlanetList(planetList);
        lord.get(3).setPlanetList(planetList);
        Mockito.when(lordRepos.findAll()).thenReturn(lord);

        List<Lord> lords = lordService.getLordsAllWithoutPlanet();

        assertEquals(lords.get(0).getPlanetList().size(), 1);
        assertEquals(lords.get(1).getPlanetList().size(), 1);
    }
}

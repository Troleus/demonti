package com.example.demonti;

import com.example.demonti.domain.Planet;
import com.example.demonti.repos.PlanetRepos;
import com.example.demonti.service.PlanetService;
import com.example.demonti.service.impl.PlanetServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;

public class PlanetServiceImplTest {

    private PlanetRepos planetRepos = mock(PlanetRepos.class);
    private PlanetService planetService = new PlanetServiceImpl(planetRepos);

    @Test
    public void shouldAddPlanet(){
        List<Planet> planetList = new ArrayList<>();
        planetService.addPlanet(new Planet("as1z"));

        Mockito.when(planetRepos.findAll()).thenReturn(planetList);

        assertEquals(planetList.size(), 1);
        assertEquals(planetList.get(0).getPlanetName(), "as1z");
    }

    @Test
    public void shouldDeletePlanet(){
        List<Planet> deleteList = Arrays.asList(new Planet("qa23s"));
        Mockito.when(planetRepos.findAll()).thenReturn(deleteList);

        planetService.delete(anyLong());

        assertEquals(deleteList.size(), 0);
    }
}

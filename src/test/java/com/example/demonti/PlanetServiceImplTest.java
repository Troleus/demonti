package com.example.demonti;

import com.example.demonti.domain.Planet;
import com.example.demonti.repos.PlanetRepos;
import com.example.demonti.service.PlanetService;
import com.example.demonti.service.impl.PlanetServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlanetServiceImplTest {

    private PlanetRepos planetRepos = mock(PlanetRepos.class);
    private PlanetService planetService = new PlanetServiceImpl(planetRepos);

    @Test
    public void shouldAddPlanet() {
        Planet planet = new Planet("as1z");
        planet.setId(12L);
        Planet newPlanet = new Planet("as1z");
        Mockito.when(planetRepos.saveAndFlush(newPlanet)).thenReturn(planet);

        Planet actualPlanet = planetService.addPlanet(newPlanet);

        assertEquals(actualPlanet.getId(), planet.getId());
        assertEquals(actualPlanet.getPlanetName(), planet.getPlanetName());
    }

    @Test
    public void shouldDeletePlanet() {
        long id = 12;

        planetService.delete(id);

        verify(planetRepos).deleteById(id);
    }
}

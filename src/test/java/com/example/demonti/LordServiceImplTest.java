package com.example.demonti;

import com.example.demonti.domain.Lord;
import com.example.demonti.repos.LordRepos;
import com.example.demonti.service.LordService;
import com.example.demonti.service.impl.LordServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class LordServiceImplTest {

    private LordRepos lordRepos = mock(LordRepos.class);
    private LordService lordService = new LordServiceImpl(lordRepos);

    @Test
    public void shouldGetAllLords() {
        List<Lord> lord = new ArrayList<>();
        lord.add(new Lord("lor", 23));
        Mockito.when(lordRepos.findAll()).thenReturn(lord);

        List<Lord> lords = lordService.findAll();

        assertEquals(lords.size(), 1);
        assertEquals(lords.get(0).getLordName(), "lor");
        assertEquals(lords.get(0).getAge(), 23);
    }

    @Test
    public void shouldGetTop10YangLords() {
        List<Lord> lord = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            lord.add(new Lord("lord", i + 1));
        }
        Mockito.when(lordRepos.findByOrderByAge()).thenReturn(lord);

        List<Lord> lords = lordService.getTop10YangLords();

        assertEquals(lords.size(), 10);
    }

    @Test
    public void shouldGetLordsAllWithoutPlanet() {
        List<Lord> lord = new ArrayList<>();
        lord.add(new Lord("a", 12));
        Mockito.when(lordRepos.getLordsAllWithoutPlanet()).thenReturn(lord);

        List<Lord> lords = lordService.getLordsAllWithoutPlanet();

        assertEquals(lords.size(), 1);
        assertNull(lords.get(0).getPlanetList());
    }

    @Test
    public void shouldFindeById(){
        Lord lord = new Lord("as", 23);
        long id = 1;
        lord.setId(id);
        Mockito.when(lordRepos.findById(id)).thenReturn(Optional.of(lord));

        Optional<Lord> lor = lordService.findById(id);

        assertTrue(lor.isPresent());
        assertEquals(lor.get().getLordName(), "as");
        assertEquals(lor.get().getAge(), 23);
    }

    @Test
    public void shouldNotFindeById(){
        long id = 1;

        Mockito.when(lordRepos.findById(id)).thenReturn(Optional.empty());

        Optional<Lord> lor = lordService.findById(id);

        assertFalse(lor.isPresent());
    }
}

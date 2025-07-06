package com.proyecto.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.proyecto.venta.model.Tienda;
import com.proyecto.venta.repository.TiendaRepository;

class TiendaServiceTest {
    @Mock
    private TiendaRepository tiendaRepository;

    @InjectMocks
    private TiendaService tiendaService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTienda(){
        Tienda tienda = new Tienda();
        tienda.setId(1);
        tienda.setNombre("Market");
        when(tiendaRepository.save(tienda)).thenReturn(tienda);

        Tienda saved = tiendaService.save(tienda);
        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Market", saved.getNombre());
    }

    @Test
    void testListTiendas() {
        Tienda tienda = new Tienda();
        tienda.setId(1);

        List<Tienda> mockTiendas = Arrays.asList(tienda);
        when(tiendaRepository.findAll()).thenReturn(mockTiendas);

        List<Tienda> response = tiendaService.listTiendas();

        assertNotNull(response);
        assertEquals(1, response.size());
        verify(tiendaRepository, times(1)).findAll();
    }

}

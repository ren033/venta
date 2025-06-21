package com.proyecto.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.venta.model.Tienda;
import com.proyecto.venta.repository.TiendaRepository;

class TiendaServiceTest {
    @Mock
    private TiendaRepository tiendaRepository;

    @InjectMocks
    private TiendaService tiendaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTienda() {
        Tienda tienda = new Tienda(1,"Market Local","Calle 2");

        when(tiendaRepository.save(tienda)).thenReturn(tienda);
        Tienda saved = tiendaService.save(tienda);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Market Local", saved.getNombre());
        assertEquals("Calle 2", saved.getDireccion());
        verify(tiendaRepository).save(tienda);
    }
}

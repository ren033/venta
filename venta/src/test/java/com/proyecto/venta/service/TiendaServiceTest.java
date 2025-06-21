package com.proyecto.venta.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

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
    void testListTienda() {
        Tienda t1 = new Tienda(1, "Market M", "Calle 2");
        Tienda t2 = new Tienda(2, "TechStock", "Calle 4");

        when(tiendaRepository.findAll()).thenReturn(Arrays.asList(t1, t2));

        List<Tienda> resultado = tiendaService.listTiendas();
        assertThat(resultado).hasSize(2).contains(t1, t2);
        verify(tiendaRepository).findAll();
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

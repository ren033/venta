package com.proyecto.venta.service;

import org.mockito.Mock;

import com.proyecto.venta.model.Factura;
import com.proyecto.venta.repository.FacturaRepository;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class FacturaServiceTest {
    @Mock
    private FacturaRepository facturaRepository;

    @InjectMocks
    private FacturaService facturaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveFactura() {
        Factura factura = new Factura();
        Factura facturaSaved = new Factura();
        
        when(facturaRepository.save(factura)).thenReturn(facturaSaved);

        Factura resultado = facturaService.save(factura);
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getTotal()).isEqualTo(5420);
        assertThat(resultado.getCupon()).isEqualTo(1);
        assertThat(resultado.getDate()).isEqualTo("17-06-2025");
        verify(facturaRepository).save(factura);
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;
        doNothing().when(facturaRepository).deleteById(id);

        facturaService.deleteById(id);
        verify(facturaRepository, times(1)).deleteById(id);
    }
}

package com.proyecto.venta.service;

import org.mockito.Mock;

import com.proyecto.venta.model.Factura;
import com.proyecto.venta.repository.FacturaRepository;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
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
    void testListFactura() {
        Factura f1 = new Factura(1, 13600, 2, "17-06-2025");

        when(facturaRepository.findAll()).thenReturn(Arrays.asList(f1));

        List<Factura> resultado = facturaService.listFacturas();
        assertThat(resultado).hasSize(1).contains(f1);
        verify(facturaRepository).findAll();
    }

    @Test
    void testSaveFactura() {
        Factura factura = new Factura();
        Factura facturaSaved = new Factura(1, 13600,2,"17-06-2025");
        
        when(facturaRepository.save(factura)).thenReturn(facturaSaved);

        Factura resultado = facturaService.save(factura);
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getTotal()).isEqualTo(13600);
        assertThat(resultado.getCupon()).isEqualTo(2);
        assertThat(resultado.getDate()).isEqualTo("17-06-2025");
        verify(facturaRepository).save(factura);
    }
}

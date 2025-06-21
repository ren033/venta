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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.repository.DetalleVentaRepository;

@SpringBootTest
@ActiveProfiles("test")
class DetalleVentaServiceTest{
    @Mock
    private DetalleVentaRepository detalleVentaRepository;

    @InjectMocks
    private DetalleVentaService detalleVentaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListDetalleVenta() {
        DetalleVenta dv1 = new DetalleVenta(1,"Cargador", 2200, 3);
        DetalleVenta dv2 = new DetalleVenta(2, "Celular", 7000, 1);

        when(detalleVentaRepository.findAll()).thenReturn(Arrays.asList(dv1, dv2));

        List<DetalleVenta> resultado = detalleVentaService.listDetalleVentas();
        assertThat(resultado).hasSize(2).contains(dv1, dv2);
        verify(detalleVentaRepository).findAll();
    }

    @Test
    public void testSaveDetalleVenta() {
        DetalleVenta detalleVenta = new DetalleVenta(1, "Cargador", 2200, 3);

        when(detalleVentaRepository.save(detalleVenta)).thenReturn(detalleVenta);
        DetalleVenta saved = detalleVentaService.save(detalleVenta);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Cargador", saved.getNombreProductoVenta());
        assertEquals(2200, saved.getPrecioProductoVenta());
        assertEquals(3, saved.getCantidadProductoVenta());
    }
}

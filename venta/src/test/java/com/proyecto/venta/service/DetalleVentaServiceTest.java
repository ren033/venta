package com.proyecto.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.repository.DetalleVentaRepository;

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

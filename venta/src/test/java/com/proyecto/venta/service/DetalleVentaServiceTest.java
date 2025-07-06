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

import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.model.Factura;
import com.proyecto.venta.repository.DetalleVentaRepository;

class DetalleVentaServiceTest{
    @Mock
    private DetalleVentaRepository detalleVentaRepository;

    @InjectMocks
    private DetalleVentaService detalleVentaService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveDetalle(){
        DetalleVenta detalle = new DetalleVenta();
        detalle.setId(1);

        when(detalleVentaRepository.save(detalle)).thenReturn(detalle);

        DetalleVenta saved = detalleVentaService.save(detalle);
        assertNotNull(saved);
        assertEquals(1, saved.getId());
    }

    @Test
    void testListDetalle() {
        DetalleVenta detalle = new DetalleVenta();
        detalle.setId(1);
        DetalleVenta detalle2 = new DetalleVenta();
        detalle2.setId(2);

        List<DetalleVenta> mockDetalles = Arrays.asList(detalle);
        when(detalleVentaRepository.findAll()).thenReturn(mockDetalles);

        List<DetalleVenta> response = detalleVentaService.listDetalleVentas();

        assertNotNull(response);
        assertEquals(2, response.size());
        verify(detalleVentaRepository, times(1)).findAll();
    }

    @Test
    void testListEmpty() {
        when(detalleVentaRepository.findAll()).thenReturn(Arrays.asList());
        List<DetalleVenta> response = detalleVentaService.listDetalleVentas();
        assertTrue(response.isEmpty());
        verify(detalleVentaRepository).findAll();
    }
}

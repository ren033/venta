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

import com.proyecto.venta.model.Factura;
import com.proyecto.venta.repository.FacturaRepository;

import jakarta.persistence.EntityNotFoundException;

class FacturaServiceTest {
    @Mock
    private FacturaRepository facturaRepository;

    @InjectMocks
    private FacturaService facturaService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveFactura(){
        Factura fact = new Factura();
        fact.setId(1);
        fact.setTotal(37800);

        when(facturaRepository.save(fact)).thenReturn(fact);

        Factura saved = facturaService.save(fact);
        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals(37800, saved.getTotal());
    }

    @Test
    void testListFacturas() {
        Factura fact = new Factura();
        fact.setId(1);
        Factura fact2 = new Factura();
        fact2.setId(2);

        List<Factura> mockFacturas = Arrays.asList(fact, fact2);
        when(facturaRepository.findAll()).thenReturn(mockFacturas);

        List<Factura> response = facturaService.listFacturas();

        assertNotNull(response);
        assertEquals(2, response.size());
        verify(facturaRepository, times(1)).findAll();
    }

    @Test
    void testListEmpty() {
        when(facturaRepository.findAll()).thenReturn(Arrays.asList());
        List<Factura> response = facturaService.listFacturas();
        assertTrue(response.isEmpty());
        verify(facturaRepository).findAll();
    }

    @Test
    void testFindByIdFactura() {
        Factura fact = new Factura();
        fact.setId(1);
        when(facturaRepository.getReferenceById(1)).thenReturn(fact);

        Factura response = facturaService.findById(1);

        assertEquals(fact, response);
        verify(facturaRepository, times(1)).getReferenceById(1);
    }

    @Test
    public void testFindByIdFactura_NotFound() {
        int id_notFound = 99;
        when(facturaRepository.getReferenceById(id_notFound)).thenThrow(new EntityNotFoundException("Factura no encontrada"));

        EntityNotFoundException thrown = assertThrows(EntityNotFoundException.class, () -> {
            facturaService.findById(id_notFound);
        });

        assertEquals("Factura no encontrada", thrown.getMessage());
        verify(facturaRepository).getReferenceById(id_notFound);
    }

    @Test
    void testDeleteFactura() {
        Factura fact = new Factura();
        fact.setId(1);

        when(facturaRepository.getReferenceById(1)).thenReturn(fact);
        doNothing().when(facturaRepository).delete(fact);

        Factura response = facturaService.deleteById(1);

        assertEquals(fact, response);
        verify(facturaRepository, times(1)).getReferenceById(1);
        verify(facturaRepository, times(1)).delete(fact);
    }

    @Test
    void testUpdateFcatura() {
        Factura fact = new Factura();
        fact.setId(1);

        when(facturaRepository.save(fact)).thenReturn(fact);

        Factura response = facturaService.update(fact);

        assertNotNull(response);
        assertEquals(fact, response);
        verify(facturaRepository, times(1)).save(fact);
    }
}

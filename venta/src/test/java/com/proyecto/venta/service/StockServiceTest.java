package com.proyecto.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.venta.model.Stock;
import com.proyecto.venta.repository.StockRepository;

class StockServiceTest {
    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveStock() {
        Stock stock = new Stock(1, "Market Local",  "Audifonos", 4, true);

        when(stockRepository.save(stock)).thenReturn(stock);
        Stock saved = stockService.save(stock);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Market Local", saved.getTienda());
        assertEquals("Audifonos", saved.getProducto());
        assertEquals(4, saved.getCantidad());
        verify(stockRepository).save(stock);
    }
}

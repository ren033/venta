package com.proyecto.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.proyecto.venta.model.Stock;
import com.proyecto.venta.repository.StockRepository;

class StockServiceTest {
    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveStock(){
        Stock stk = new Stock();
        stk.setId(1);
        when(stockRepository.save(stk)).thenReturn(stk);

        Stock saved = stockService.save(stk);
        assertNotNull(saved);
        assertEquals(1, saved.getId());
    }
}

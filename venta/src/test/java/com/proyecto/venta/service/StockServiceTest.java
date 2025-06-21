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

import com.proyecto.venta.model.Stock;
import com.proyecto.venta.repository.StockRepository;

@SpringBootTest
@ActiveProfiles("test")
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
    void testListStock() {
        Stock s1 = new Stock(1, "Market M", "Audifinos", 12, true);
        Stock s2 = new Stock(2, "Market M", "Cargador", 0, false);
        Stock s3 = new Stock(3, "Market M", "Celular", 7, true);
        Stock s4 = new Stock(4, "TechStock", "Cargador", 10, true);

        when(stockRepository.findAll()).thenReturn(Arrays.asList(s1, s2, s3, s4));

        List<Stock> resultado = stockService.listStock();
        assertThat(resultado).hasSize(4).contains(s1, s2, s3, s4);
        verify(stockRepository).findAll();
    }

    @Test
    public void testSaveStock() {
        Stock stock = new Stock(1, "Market M",  "Audifonos", 12, true);

        when(stockRepository.save(stock)).thenReturn(stock);
        Stock saved = stockService.save(stock);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Market M", saved.getTienda());
        assertEquals("Audifonos", saved.getProducto());
        assertEquals(12, saved.getCantidad());
        verify(stockRepository).save(stock);
    }
}

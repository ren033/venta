package com.proyecto.venta.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        Stock stk = new Stock();
        stk.setId(1);
        stk.setStockTienda("Market");
        stk.setStockProducto("Cargador");
        stk.setCantidad(17);
        stk.setDisponibilidad(true);
    }
}

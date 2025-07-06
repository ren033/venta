package com.proyecto.venta.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.proyecto.venta.model.Tienda;
import com.proyecto.venta.repository.TiendaRepository;

@SpringBootTest
@ActiveProfiles("test")
class TiendaServiceTest {
    @Mock
    private TiendaRepository tiendaRepository;

    @InjectMocks
    private TiendaService tiendaService;

    @BeforeEach
    void setUp() {
        Tienda tienda = new Tienda();
        tienda.setId(1);
        tienda.setNombre("Market");
        tienda.setDireccion("Calle 5");
    }
}

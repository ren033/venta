package com.proyecto.venta.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
}

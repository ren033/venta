package com.proyecto.venta.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.venta.repository.TiendaRepository;

class TiendaServiceTest {
    @Mock
    private TiendaRepository tiendaRepository;

    @InjectMocks
    private TiendaService tiendaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

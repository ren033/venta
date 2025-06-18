package com.proyecto.venta.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.venta.model.Cliente;
import com.proyecto.venta.repository.ClienteRepository;

public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCliente() {
        Cliente cliente = new Cliente();
        Cliente clienteSaved = new Cliente();
        
        when(clienteRepository.save(cliente)).thenReturn(clienteSaved);

        Cliente resultado = clienteService.save(cliente);
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getPassword()).isEqualTo("pass");
        assertThat(resultado.getUsername()).isEqualTo("");
        assertThat(resultado.getNombre()).isEqualTo("");
        assertThat(resultado.getCorreo()).isEqualTo("");
        assertThat(resultado.getDireccion()).isEqualTo("");
        verify(clienteRepository).save(cliente);
    }
}

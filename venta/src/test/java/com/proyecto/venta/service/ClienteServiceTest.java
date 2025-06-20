package com.proyecto.venta.service;

//import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
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
/*
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
        assertThat(resultado.getDireccion()).isEqualTo("Calle 23");
        verify(clienteRepository).save(cliente);
    }
*/

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente(1, "pass", "usercarlos",
            "Carlos","carlos@gmail.com", "Calle 23", true);

        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente saved = clienteService.save(cliente);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals("Carlos", saved.getNombre());
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;
        doNothing().when(clienteRepository).deleteById(id);

        clienteService.deleteById(id);
        verify(clienteRepository, times(1)).deleteById(id);
    }
}

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

import com.proyecto.venta.model.Cliente;
import com.proyecto.venta.repository.ClienteRepository;

@SpringBootTest
@ActiveProfiles("test")
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
    void testListClientes() {
        Cliente c1 = new Cliente(1, "pass", "usercarlos", "Carlos", "carlos@gmail.com", "Calle 23", true);
        Cliente c2 = new Cliente(2, "passw0rd", "anonimo", "Antonio", "anon@gmail.com", "Edificio A2", true);

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Cliente> resultado = clienteService.listClientes();
        assertThat(resultado).hasSize(2).contains(c1, c2);
        verify(clienteRepository).findAll();
    }

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
    public void testDeleteCliente() {
        int id = 1;
        doNothing().when(clienteRepository).deleteById(id);

        clienteService.deleteById(id);
        verify(clienteRepository, times(1)).deleteById(id);
    }
}

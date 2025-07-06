package com.proyecto.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.proyecto.venta.model.Producto;
import com.proyecto.venta.repository.ProductoRepository;

class ProductoServiceTest {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveProducto(){
        Producto prod = new Producto();
        prod.setId(1);
        prod.setNombre("Audifonos");
        prod.setPrecio(32000);
        when(productoRepository.save(prod)).thenReturn(prod);

        Producto saved = productoService.save(prod);
        assertNotNull(saved);
        assertEquals(1, saved.getId());
    }

    @Test
    void testListProductos() {
        Producto prod = new Producto();
        prod.setId(1);
        Producto prod2 = new Producto();
        prod2.setId(2);

        List<Producto> mockProductos = Arrays.asList(prod, prod2);
        when(productoRepository.findAll()).thenReturn(mockProductos);

        List<Producto> response = productoService.listProductos();

        assertNotNull(response);
        assertEquals(2, response.size());
        verify(productoRepository, times(1)).findAll();
    }

}

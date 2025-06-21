package com.proyecto.venta.service;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.proyecto.venta.model.Producto;
import com.proyecto.venta.repository.ProductoRepository;

@SpringBootTest
@ActiveProfiles("test")
class ProductoServiceTest {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProducto() {
        Producto producto = new Producto();
        Producto productoSaved = new Producto(1, "Audifonos", 4500);
        
        when(productoRepository.save(producto)).thenReturn(productoSaved);

        Producto resultado = productoService.save(producto);
        assertThat(resultado.getId()).isEqualTo(1);
        assertThat(resultado.getNombre()).isEqualTo("Audifonos");
        assertThat(resultado.getPrecio()).isEqualTo(4500);
        verify(productoRepository).save(producto);
    }

    @Test
    void testListProductos() {
        Producto p1 = new Producto(1, "Audifonos", 4500);
        Producto p2 = new Producto(2, "Cargador", 2200);
        Producto p3 = new Producto(3, "Celular", 7000);

        when(productoRepository.findAll()).thenReturn(Arrays.asList(p1, p2, p3));

        List<Producto> resultado = productoService.listProductos();
        assertThat(resultado).hasSize(3).contains(p1, p2, p3);
        verify(productoRepository).findAll();
    }
}

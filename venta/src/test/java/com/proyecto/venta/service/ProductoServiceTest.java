package com.proyecto.venta.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        Producto p1 = new Producto();
        p1.setId(1);
        p1.setNombre("Audifonos");
        p1.setPrecio(32000);

        Producto p2 = new Producto();
        p2.setId(2);
        p2.setNombre("Cargado");
        p2.setPrecio(7000);

        Producto p3 = new Producto();
        p3.setId(3);
        p3.setNombre("Celular");
        p3.setPrecio(440000);
    }
}

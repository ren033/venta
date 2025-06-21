package com.proyecto.venta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.venta.model.Producto;
import com.proyecto.venta.service.ProductoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
//import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Producto producto;
    @BeforeEach
    void setUp() {
        producto = new Producto();
        producto.setId(1);
        producto.setNombre("Audifonos");
        producto.setPrecio(4500);

        producto = new Producto();
        producto.setId(2);
        producto.setNombre("Cargador");
        producto.setPrecio(2200);

        producto = new Producto();
        producto.setId(3);
        producto.setNombre("Celular");
        producto.setPrecio(7000);
    }

    @Test
    void testListProductos() throws Exception {
        Producto p1 = new Producto(1, "Audifonos", 4500);
        Producto p2 = new Producto(2, "Cargador", 2200);
        Producto p3 = new Producto(3, "Celular", 7000);

        Mockito.when(productoService.listProductos()).thenReturn(Arrays.asList(p1, p2, p3));

        mockMvc.perform(get("/api/producto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Audifonos"))
                .andExpect(jsonPath("$[1].nombre").value("Cargador"));
    }

    @Test
    void testSaveProducto() throws Exception {
        Producto producto = new Producto();
        Producto productoSaved = new Producto(1, "Audifonos", 4500);

        Mockito.when(productoService.save(any(Producto.class)))
                .thenReturn(productoSaved);

        mockMvc.perform(post("/api/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Audifonos"));
    }
}
package com.proyecto.venta.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.service.DetalleVentaService;

public class DetalleVentaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DetalleVentaService detalleVentaService;

    @Autowired
    private ObjectMapper objectMapper;

    private DetalleVenta detalle;
    private DetalleVenta detalle2;

    @BeforeEach
    void setUp(){
        detalle.setId(1);
        detalle.setNomProductoVenta("Audifonos");
        detalle.setPrecioProductoVenta(32000);
        detalle.setCantProductoVenta(1);

        detalle2.setId(1);
        detalle2.setNomProductoVenta("Cargador");
        detalle2.setPrecioProductoVenta(12000);
        detalle2.setCantProductoVenta(2);
    }

    @Test
    void listDetalleVentas() throws Exception {
        when(detalleVentaService.listDetalleVentas()).thenReturn(Arrays.asList(detalle, detalle2));

        mockMvc.perform(get("/api/Detalle/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(detalle.getId()))
                .andExpect(jsonPath("$[1].id").value(detalle2.getId()));
    }
}

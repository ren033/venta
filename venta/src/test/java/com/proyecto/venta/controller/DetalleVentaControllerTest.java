/* 
package com.proyecto.venta.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

        mockMvc.perform(get("/api/Venta/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(detalle.getId()))
                .andExpect(jsonPath("$[1].id").value(detalle2.getId()));
    }

    @Test
    void listDetalleVentas_Empty() throws Exception {
        when(detalleVentaService.listDetalleVentas()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/Venta/list"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createDetalleVenta() throws Exception {
        when(detalleVentaService.save(any())).thenReturn(detalle);

        mockMvc.perform(post("/api/Venta/create/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detalle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(detalle.getId()));
    }

    @Test
    void getDetalleById() throws Exception {
        when(detalleVentaService.listDetalleVentas()).thenReturn(Arrays.asList(detalle, detalle2));

        mockMvc.perform(get("/api/Venta/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(detalle.getId()));
    }

    @Test
    void deleteDetalle() throws Exception {
        when(detalleVentaService.listDetalleVentas()).thenReturn(Arrays.asList(detalle));

        mockMvc.perform(delete("/api/Venta/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Detalle de Venta eliminado"));

        verify(detalleVentaService).deleteById(1);
    }
}
*/
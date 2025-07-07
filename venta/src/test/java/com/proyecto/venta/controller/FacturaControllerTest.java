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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.venta.model.Factura;
import com.proyecto.venta.model.UsuarioDTO;
import com.proyecto.venta.service.FacturaService;

public class FacturaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacturaService facturaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Factura fact;
    private UsuarioDTO cliente;

    @BeforeEach
    void setUp(){
        fact.setId(1);
        fact.setIdCliente(1);
        fact.setDetalle(1);
        fact.setCupon(2);
        fact.setTotal(45000);

        cliente.setId(1);
        cliente.setNombre("Cliente test");
    }

    @Test
    void listFacturas() throws Exception {
        when(facturaService.listFacturas()).thenReturn(Arrays.asList(fact));

        mockMvc.perform(get("/api/Factura/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(fact.getId()));
    }

    @Test
    void listFacturas_Empty() throws Exception {
        when(facturaService.listFacturas()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/Factura/list"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createFactura() throws Exception {
        when(facturaService.getUsuarioById(1)).thenReturn(cliente);
        when(facturaService.create(any())).thenReturn(fact);

        mockMvc.perform(post("/api/Factura/create/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fact)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(fact.getId()));
    }

    @Test
    void getFacturaById() throws Exception {
        when(facturaService.listFacturas()).thenReturn(Arrays.asList(fact));

        mockMvc.perform(get("/api/Venta/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(fact.getId()));
    }

    @Test
    void deleteFactura() throws Exception {
        when(facturaService.listFacturas()).thenReturn(Arrays.asList(fact));

        mockMvc.perform(delete("/api/Facturas/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Factura eliminada"));

        verify(facturaService).deleteById(1);
    }
}
*/
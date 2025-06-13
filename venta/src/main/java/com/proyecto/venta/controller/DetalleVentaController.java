package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.service.DetalleVentaService;


@RestController
@RequestMapping("/api/DetalleVenta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> getAll()
    {
        List<DetalleVenta> productos = detalleVentaService.listDetalleVentas();
    }
}

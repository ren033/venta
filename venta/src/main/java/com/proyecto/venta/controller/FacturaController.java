package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.venta.model.Factura;
import com.proyecto.venta.service.FacturaService;

@RestController
@RequestMapping("/api/Factura")
public class FacturaController
{
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> getAll()
    {
        List<Factura> facturas = facturaService.listFacturas();
        if (!facturas.isEmpty()) {
            return new ResponseEntity<>(facturas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/id")
    public void deleteFactura(@PathVariable int id){
        facturaService.deleteById(id);
    }
}

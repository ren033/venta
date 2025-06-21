package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id")
    public ResponseEntity<Factura> getById(@PathVariable int id){
        return new ResponseEntity<Factura>(facturaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Factura> postFactura(@RequestBody Factura factura)
    {
        Factura search = facturaService.findById(factura.getId());
        if (search == null) {
            return new ResponseEntity<>(facturaService.save(factura), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id")
    public void deleteFactura(@PathVariable int id){
        facturaService.deleteById(id);
    }

    
}

package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.service.DetalleVentaService;

@RestController
@RequestMapping("/api/Venta")
public class DetalleVentaController
{
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> getAll()
    {
        List<DetalleVenta> detalleVentas = detalleVentaService.listDetalleVentas();
        if (!detalleVentas.isEmpty()) {
            return new ResponseEntity<>(detalleVentas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<DetalleVenta> getById(@PathVariable int id){
        return new ResponseEntity<DetalleVenta>(detalleVentaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <DetalleVenta> postDetalleVenta(@RequestBody DetalleVenta detalleVenta)
    {
        DetalleVenta search = detalleVentaService.findById(detalleVenta.getId());
        if (search == null) {
            return new ResponseEntity<>(detalleVentaService.save(detalleVenta), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id")
    public void deleteDetalleVenta(@PathVariable int id){
        detalleVentaService.deleteById(id);
    }

    @PutMapping("/id")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@RequestBody DetalleVenta detalleVenta, @PathVariable int id)
    {
        List<DetalleVenta> updateDetalleVenta = detalleVentaService.listDetalleVentas();
        if (!updateDetalleVenta.isEmpty())
            return ResponseEntity.notFound().build();
            detalleVenta.setId(id);
            detalleVentaService.save(detalleVenta);
            return ResponseEntity.noContent().build();
    }
}

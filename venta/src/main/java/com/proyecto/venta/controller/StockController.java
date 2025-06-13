package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.venta.model.Stock;
import com.proyecto.venta.service.StockService;

@RestController
@RequestMapping("/api/Stock")
public class StockController
{
    @Autowired
    private StockService stockService;
    @GetMapping
    public ResponseEntity<List<Stock>> getAll()
    {
        List<Stock> productos = stockService.listStock();
        if (!productos.isEmpty()) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

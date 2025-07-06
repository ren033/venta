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
        List<Stock> stocks = stockService.listStock();
        if (!stocks.isEmpty()) {
            return new ResponseEntity<>(stocks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Stock> getById(@PathVariable int id){
        return new ResponseEntity<Stock>(stockService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Stock> postStock(@RequestBody Stock stock)
    {
        Stock search = stockService.findById(stock.getId());
        if (search == null) {
            return new ResponseEntity<>(stockService.save(stock), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id")
    public void deleteStock(@PathVariable int id){
        stockService.deleteById(id);
    }

    @PutMapping("/id")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock, @PathVariable int id)
    {
        List<Stock> updateStock = stockService.listStock();
        if (!updateStock.isEmpty())
            return ResponseEntity.notFound().build();
            stock.setId(id);
            stockService.save(stock);
            return ResponseEntity.noContent().build();
    }
}

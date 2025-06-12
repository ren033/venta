package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.proyecto.venta.model.Producto;
import com.proyecto.venta.service.ProductoService;

@RestController
@RequestMapping("/api/Producto")
public class ProductoController
{
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAll()
    {
        List<Producto> productos = productoService.listProductos();
        if (!productos.isEmpty()) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Producto> getById(@PathVariable int id){
        return new ResponseEntity<Producto>(productoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/Producto")
    public ResponseEntity<Producto> getByName(@PathVariable String nombre){
        return new ResponseEntity<Producto>(productoService.findByName(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Producto> postProducto(@RequestBody Producto producto)
    {
        Producto search = productoService.findById(producto.getId());
        if (search == null) {
            return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id")
    public void deleteProducto(@PathVariable int id){
        productoService.deleteById(id);
    }

        @PutMapping("id")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto, @PathVariable int id)
    {
        List<Producto> updateProducto = productoService.listProductos();
        if (!updateProducto.isEmpty())
            return ResponseEntity.notFound().build();
            producto.setId(id);
            productoService.save(producto);
            return ResponseEntity.noContent().build();
    }
}

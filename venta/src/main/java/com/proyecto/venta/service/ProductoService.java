package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.Producto;
import com.proyecto.venta.repository.ProductoRepository;

@Service
public class ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listProductos(){
        return productoRepository.findAll();
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto findById(int id){
        return productoRepository.getReferenceById(id);
    }

    public Producto findByName(String nombre){
        return productoRepository.getByName(nombre);
    }

    public Producto deleteById(int id){
        return productoRepository.getReferenceById(id);
    }
}


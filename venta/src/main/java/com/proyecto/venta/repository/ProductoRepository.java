package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer>
{
    List<Producto> FindAll();

    @SuppressWarnings({ "unchecked", "null" })
    Producto save (Producto producto);

    Producto getReferenceById(int id);
    Producto getByName(String nombre);
}

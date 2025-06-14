package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.DetalleVenta;

@Repository
public interface DetalleVentaRepository extends JpaRepository <DetalleVenta, Integer>
{
    List<DetalleVenta> FindAll();

    @SuppressWarnings({ "unchecked", "null" })
    DetalleVenta save (DetalleVenta detalleVenta);

    DetalleVenta getReferenceById(int id);
}

package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Integer>{
    List<Factura> FindAll();
}

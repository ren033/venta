package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.Cupon;

@Repository
public interface CuponRepository extends JpaRepository <Cupon, Integer>
{
    List<Cupon> FindAll();

    @SuppressWarnings({ "unchecked", "null" })
    Cupon save (Cupon cupon);

    Cupon getReferenceById(int id);
}

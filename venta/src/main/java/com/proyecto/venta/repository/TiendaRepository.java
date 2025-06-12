package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer>{
    List<Tienda> FindAll();

    @SuppressWarnings({ "unchecked", "null" })
    Tienda save (Tienda tienda);

    Tienda getReferenceById(int id);
}

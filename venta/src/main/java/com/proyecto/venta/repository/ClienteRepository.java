package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>
{
    List<Cliente> FindAll();

    @SuppressWarnings({ "unchecked", "null" })
    Cliente save (Cliente cliente);

    Cliente getReferenceById(int id);
    Cliente getByName(String nombre);
}

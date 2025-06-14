package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.Tienda;
import com.proyecto.venta.repository.TiendaRepository;

@Service
public class TiendaService
{
    @Autowired
    private TiendaRepository tiendaRepository;

    public List<Tienda> listTiendas(){
        return tiendaRepository.findAll();
    }

    public Tienda save(Tienda tienda){
        return tiendaRepository.save(tienda);
    }

    public Tienda findById(int id){
        return tiendaRepository.getReferenceById(id);
    }

    public Tienda deleteById(int id){
        return tiendaRepository.getReferenceById(id);
    }
}

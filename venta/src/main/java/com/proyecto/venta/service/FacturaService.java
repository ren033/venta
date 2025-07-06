package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.Factura;
import com.proyecto.venta.repository.FacturaRepository;

@Service
public class FacturaService
{
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> listFacturas(){
        return facturaRepository.findAll();
    }

    public Factura save(Factura factura){
        return facturaRepository.save(factura);
    }

    public Factura findById(int id){
        return facturaRepository.getReferenceById(id);
    }

    public Factura deleteById(int id) {
    Factura factura = facturaRepository.getReferenceById(id);
    facturaRepository.delete(factura);
    return factura;
    }

    public Factura update(Factura factura){
        return facturaRepository.save(factura);
    }
}

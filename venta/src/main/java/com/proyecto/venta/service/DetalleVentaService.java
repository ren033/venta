package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.DetalleVenta;
import com.proyecto.venta.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService
{
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    
    public List<DetalleVenta> listDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta save(DetalleVenta detalleVenta){
        return detalleVentaRepository.save(detalleVenta);
    }

    public DetalleVenta findById(int id){
        return detalleVentaRepository.getReferenceById(id);
    }

    public DetalleVenta deleteById(int id){
        return detalleVentaRepository.getReferenceById(id);
    }
}

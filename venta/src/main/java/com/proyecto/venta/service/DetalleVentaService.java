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
}

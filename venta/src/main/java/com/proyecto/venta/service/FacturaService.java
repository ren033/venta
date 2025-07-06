package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.venta.model.Factura;
import com.proyecto.venta.model.UsuarioDTO;
import com.proyecto.venta.repository.FacturaRepository;

@Service
public class FacturaService
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FacturaRepository facturaRepository;

    public UsuarioDTO getUsuarioById(Integer id) {
        String url = "http://localhost:8083/api/usuario/" + id;
        return restTemplate.getForObject(url, UsuarioDTO.class);
    }

    public Factura create(Factura resupply) {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = "http://localhost:8083/api/usuario/" + resupply.getIdCliente();
        UsuarioDTO cliente = restTemplate.getForObject(url, UsuarioDTO.class);
        
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado con ID: " + resupply.getIdCliente());
        }

            resupply.setIdCliente(cliente.getId());
            return facturaRepository.save(resupply);
    }

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

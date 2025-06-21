package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.Cliente;
import com.proyecto.venta.repository.ClienteRepository;

@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listClientes(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente findById(int id){
        return clienteRepository.getReferenceById(id);
    }

    public Cliente findByName(String nombre){
        return clienteRepository.getByName(nombre);
    }

    public Cliente deleteById(int id){
        return clienteRepository.getReferenceById(id);
    }
}

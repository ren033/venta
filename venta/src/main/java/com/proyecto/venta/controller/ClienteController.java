package com.proyecto.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.venta.model.Cliente;
import com.proyecto.venta.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController
{
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll()
    {
        List<Cliente> clientes = clienteService.listClientes();
        if (!clientes.isEmpty()) {
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Cliente> getById(@PathVariable int id){
        return new ResponseEntity<Cliente>(clienteService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/Cliente")
    public ResponseEntity<Cliente> getByName(@PathVariable String nombre){
        return new ResponseEntity<Cliente>(clienteService.findByName(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Cliente> postCliente(@RequestBody Cliente cliente)
    {
        Cliente search = clienteService.findById(cliente.getId());
        if (search == null) {
            return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id")
    public void deleteCliente(@PathVariable int id){
        clienteService.deleteById(id);
    }
}

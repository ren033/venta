package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.Cupon;
import com.proyecto.venta.repository.CuponRepository;

@Service
public class CuponService
{
    @Autowired
    private CuponRepository cuponRepository;

    public List<Cupon> listCupones(){
        return cuponRepository.findAll();
    }

    public Cupon save(Cupon cupon){
        return cuponRepository.save(cupon);
    }

    public Cupon findById(int id){
        return cuponRepository.getReferenceById(id);
    }

    public Cupon deleteById(int id){
        return cuponRepository.getReferenceById(id);
    }
}

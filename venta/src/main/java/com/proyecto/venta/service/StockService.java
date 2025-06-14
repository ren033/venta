package com.proyecto.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.model.Stock;
import com.proyecto.venta.repository.StockRepository;

@Service
public class StockService
{
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> listStock(){
        return stockRepository.findAll();
    }

    public Stock save(Stock stock){
        return stockRepository.save(stock);
    }

    public Stock findById(int id){
        return stockRepository.getReferenceById(id);
    }

    public Stock deleteById(int id){
        return stockRepository.getReferenceById(id);
    }
}

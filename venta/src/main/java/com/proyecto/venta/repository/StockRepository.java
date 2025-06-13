package com.proyecto.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.venta.model.Stock;

@Repository
public interface StockRepository extends JpaRepository <Stock, Integer>
{
    List<Stock> FindAll();

    @SuppressWarnings({ "unchecked", "null" })
    Stock save (Stock stock);
}

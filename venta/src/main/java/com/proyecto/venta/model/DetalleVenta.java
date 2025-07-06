package com.proyecto.venta.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Detalle Venta")

public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private int id;

    @OneToMany()
    @JsonManagedReference
    @JoinColumn(referencedColumnName = "Producto")
    private String nomProductoVenta;

    @JsonManagedReference
    @JoinColumn(referencedColumnName = "Precio")
    private int precioProductoVenta;

    @Column(name = "Cantidad", nullable = false)
    private int cantProductoVenta;
}

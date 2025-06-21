package com.proyecto.venta.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Stock")

public class Stock
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Tienda asociada")
    private String tienda;

    @OneToMany()
    @JsonManagedReference
    @JoinColumn(referencedColumnName = "Producto")
    private String producto;

    @Column(name = "Cantidad", nullable = false)
    private int cantidad;

    @Column(name = "Disponibilidad", nullable = false)
    private boolean disponibilidad;
}

package com.proyecto.venta.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Factura")

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private int id;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(name = "Total", nullable = false)
    private int total;

    @OneToMany
    @JoinColumn(referencedColumnName = "Cupon")
    private int cupon;

    @Column(name = "Fecha", nullable = false)
    private String date;
}

package com.proyecto.venta.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Column(name = "Usuario",nullable = false)
    private String nombreUsuario;

    @OneToMany
    @JoinColumn(referencedColumnName = "Detalle")
    private int detalle;

    @Column(name = "Total", nullable = false)
    private int total;

    @OneToMany
    @JoinColumn(referencedColumnName = "Cupon")
    private int cupon;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;
}

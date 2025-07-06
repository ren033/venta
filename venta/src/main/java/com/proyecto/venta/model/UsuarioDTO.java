package com.proyecto.venta.model;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private Integer rol;
    private boolean activo;
}

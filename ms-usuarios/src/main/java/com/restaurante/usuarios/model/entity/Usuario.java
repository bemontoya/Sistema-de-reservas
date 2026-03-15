package com.restaurante.usuarios.model.entity;

import jakarta.persistence.*; //Esto importa las herramientas para que java trabaje con bases de datos relaciones
import lombok.Data; // Eliminar codigo repetitivo

@Entity
@Table(name = "usuarios")
@Data // Esto genera los getters y setters automáticamente
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;
}

package com.example.cliente.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="clientes")
@Data //Genera los getters, setters, toString, etc.

public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefono;
}

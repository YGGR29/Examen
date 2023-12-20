package com.examen.pokemonapp.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String email;

    @OneToMany(mappedBy = "entrenador")
    private List<Pokemon> pokemones;

    // Getters y Setters
}

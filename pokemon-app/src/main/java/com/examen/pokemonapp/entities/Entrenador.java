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

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }
}
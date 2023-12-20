package com.examen.pokemonapp.entities;

import jakarta.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String descripcion;
    private String fechaDescubrimiento;
    private int generacion;

    @ManyToOne
    @JoinColumn(name = "tipo_pokemon_id")
    private Tipopokemon tipoPokemon;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaDescubrimiento() {
        return fechaDescubrimiento;
    }

    public void setFechaDescubrimiento(String fechaDescubrimiento) {
        this.fechaDescubrimiento = fechaDescubrimiento;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public Tipopokemon getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(Tipopokemon tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
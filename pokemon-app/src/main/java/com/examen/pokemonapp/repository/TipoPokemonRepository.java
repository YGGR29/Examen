package com.examen.pokemonapp.repository;

import com.examen.pokemonapp.entities.Tipopokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoPokemonRepository extends JpaRepository<Tipopokemon, Long> {
    Optional<Tipopokemon> findByDescripcion(String descripcion);
    
}


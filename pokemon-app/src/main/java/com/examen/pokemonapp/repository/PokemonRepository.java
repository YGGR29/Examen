package com.examen.pokemonapp.repository;

import com.examen.pokemonapp.entities.Pokemon;
import com.examen.pokemonapp.entities.Tipopokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByTipoPokemon(Tipopokemon tipoPokemon);
   
}

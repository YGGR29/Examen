package com.examen.pokemonapp.services;

import com.examen.pokemonapp.entities.Tipopokemon;
import com.examen.pokemonapp.repository.TipoPokemonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoPokemonService {

    private final TipoPokemonRepository tipoPokemonRepository;

 
    public TipoPokemonService(TipoPokemonRepository tipoPokemonRepository) {
        this.tipoPokemonRepository = tipoPokemonRepository;
    }

    public Optional<Tipopokemon> getTipoPokemonByDescripcion(String descripcion) {
        return tipoPokemonRepository.findByDescripcion(descripcion);
    }

    public Tipopokemon saveTipoPokemon(Tipopokemon tipoPokemon) {
      
        return tipoPokemonRepository.save(tipoPokemon);
    }

	public Tipopokemon getByDescripcion(String tipo) {
		
		return null;
	}

 
}

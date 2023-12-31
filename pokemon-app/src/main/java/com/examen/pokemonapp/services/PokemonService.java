package com.examen.pokemonapp.services;

import com.examen.pokemonapp.entities.Pokemon;
import com.examen.pokemonapp.entities.Tipopokemon;
import com.examen.pokemonapp.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemonesByTipo(Tipopokemon tipoPokemon) {
        return pokemonRepository.findByTipoPokemon(tipoPokemon);
    }

    public Pokemon savePokemon(Pokemon pokemon) {
     
        return pokemonRepository.save(pokemon);
    }

	public Pokemon registrarPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pokemon getByUuid(String pokemonUuid) {
		// TODO Auto-generated method stub
		return null;
	}

    
}


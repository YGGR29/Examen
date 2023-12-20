package com.examen.pokemonapp.controller;

import com.examen.pokemonapp.entities.Entrenador;
import com.examen.pokemonapp.entities.Pokemon;
import com.examen.pokemonapp.services.EntrenadorService;
import com.examen.pokemonapp.services.PokemonService;
import com.examen.pokemonapp.services.TipoPokemonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private TipoPokemonService tipoPokemonService;

    @GetMapping("/{tipo}")
    public ResponseEntity<List<Pokemon>> getPokemonsByTipo(@PathVariable String tipo) {
        try {
            List<Pokemon> pokemons = pokemonService.getPokemonesByTipo(tipoPokemonService.getByDescripcion(tipo));
            return ResponseEntity.ok(pokemons);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }
    @Autowired
    private PokemonService pokemonService1;

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping
    
    public ResponseEntity<Pokemon> registrarPokemon(@RequestBody Pokemon pokemon) {
        try {

            Entrenador entrenador = entrenadorService.getById(pokemon.getEntrenador().getId());
            if (entrenador != null) {
           
                pokemon.setEntrenador(entrenador);
                Pokemon nuevoPokemon = pokemonService.registrarPokemon(pokemon);
                return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPokemon);
            } else {
                
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } 
    
}


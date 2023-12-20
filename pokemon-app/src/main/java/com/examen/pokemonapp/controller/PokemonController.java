package com.examen.pokemonapp.controller;

import com.examen.pokemonapp.entities.Pokemon;
import com.examen.pokemonapp.entities.Tipopokemon;
import com.examen.pokemonapp.services.PokemonService;
import com.examen.pokemonapp.services.TipoPokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;
    private final TipoPokemonService tipoPokemonService;

    public PokemonController(PokemonService pokemonService, TipoPokemonService tipoPokemonService) {
        this.pokemonService = pokemonService;
        this.tipoPokemonService = tipoPokemonService;
    }

    @GetMapping("/{tipo}")
    public List<Pokemon> getPokemonesByTipo(@PathVariable String tipo) {
        Tipopokemon tipoPokemon = tipoPokemonService.getTipoPokemonByDescripcion(tipo)
                .orElseThrow(() -> new RuntimeException("Tipo de Pokémon no encontrado: " + tipo));
        return pokemonService.getPokemonesByTipo(tipoPokemon);
    }

    @PostMapping("/save")
    public Pokemon savePokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.savePokemon(pokemon);
    }

}

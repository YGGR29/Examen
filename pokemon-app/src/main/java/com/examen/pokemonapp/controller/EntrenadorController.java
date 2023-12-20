package com.examen.pokemonapp.controller;

import com.examen.pokemonapp.entities.Entrenador;
import com.examen.pokemonapp.services.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;


    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/all")
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorService.getAllEntrenadores();
    }

    @GetMapping("/{id}")
    public Entrenador getEntrenadorById(@PathVariable Long id) {
        return entrenadorService.getEntrenadorById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con ID: " + id));
    }

    @PostMapping("/save")
    public Entrenador saveEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.saveEntrenador(entrenador);
    }

  
}

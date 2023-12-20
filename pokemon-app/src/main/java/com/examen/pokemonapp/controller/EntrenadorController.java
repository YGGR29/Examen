package com.examen.pokemonapp.controller;
import com.examen.pokemonapp.entities.Entrenador;
import com.examen.pokemonapp.services.EntrenadorService;
import jakarta.persistence.EntityNotFoundException;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Entrenador requestEntrenador) {
        try {
            Optional<Entrenador> entrenadorOptional = entrenadorService.getEntrenadorByEmail(requestEntrenador.getEmail());

            if (entrenadorOptional.isPresent()) {
                Long uuid = entrenadorOptional.get().getId();
                Map<String, String> response = new HashMap<>();
              
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(401).build(); // Unauthorized
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(400).build(); // Bad Request
        }
    }
    
    private EntrenadorService EntrenadorService;

    @GetMapping("/{uuid}/pokemones")
    public ResponseEntity<List> getPokemonesByEntrenador(@PathVariable String uuid) {
        try {
            Entrenador entrenador = entrenadorService.getById(uuid);
            if (entrenador != null) {
                List pokemones = (List) entrenador.getPokemones();
                return ResponseEntity.ok(pokemones);
            } else {
                return ResponseEntity.notFound().build(); 
            }
        } catch (Exception e) {
          
            return ResponseEntity.status(500).build();
        }
    }
}

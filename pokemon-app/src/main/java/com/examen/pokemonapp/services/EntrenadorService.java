package com.examen.pokemonapp.services;

import com.examen.pokemonapp.entities.Entrenador;
import com.examen.pokemonapp.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> getEntrenadorById(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Optional<Entrenador> getEntrenadorByEmail(String email) {
        return entrenadorRepository.findByEmail(email);
    }

    public Entrenador saveEntrenador(Entrenador entrenador) {
   
        return entrenadorRepository.save(entrenador);
    }

}

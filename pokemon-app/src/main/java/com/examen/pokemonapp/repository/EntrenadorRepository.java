package com.examen.pokemonapp.repository;

import com.examen.pokemonapp.entities.Entrenador;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
	Optional<Entrenador> findByEmail(String email);
}


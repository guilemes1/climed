package com.app.cinema.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.cinema.Entity.Paciente;

// Interface para representar o Repositorio da tabela Filme
public interface PacienteRepository extends CrudRepository<Paciente, Integer>{
    Optional<Paciente> findByCpf(String cpf);
}

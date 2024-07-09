package com.app.climed.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.climed.Entity.Paciente;

// Interface para representar o Repositorio da tabela Paciente
public interface PacienteRepository extends CrudRepository<Paciente, Integer>{
    Optional<Paciente> findByCpf(String cpf);
}

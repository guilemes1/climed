package com.app.cinema.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.cinema.Entity.Especialidade;

// Interface para representar o Repositorio da tabela Especialidade
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer>{
    Optional<Especialidade> findByNomeEspecialidade(String especialidade);
}

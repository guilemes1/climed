package com.app.climed.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.climed.Entity.Especialidade;

// Interface para representar o Repositorio da tabela Especialidade
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer>{
    Optional<Especialidade> findByNomeEspecialidade(String especialidade);
}

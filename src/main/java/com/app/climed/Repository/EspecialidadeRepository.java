package com.app.climed.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.climed.Entity.Especialidade;

import jakarta.persistence.Tuple;

// Interface para representar o Repositorio da tabela Especialidade
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer>{
    Optional<Especialidade> findByNomeEspecialidade(String especialidade);

    @Query(value = "SELECT id_especialidade, nome_especialidade from especialidade", nativeQuery = true)
    List<Tuple> listarEspecialidades();
}
package com.app.climed.Repository;

import org.springframework.data.repository.CrudRepository;

import com.app.climed.Entity.Consulta;

// Interface para representar o Repositorio da tabela Evento
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    
}
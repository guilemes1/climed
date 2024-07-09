package com.app.cinema.Repository;

import org.springframework.data.repository.CrudRepository;

import com.app.cinema.Entity.Consulta;

// Interface para representar o Repositorio da tabela Evento
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    
}

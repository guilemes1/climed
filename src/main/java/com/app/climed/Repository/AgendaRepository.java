package com.app.climed.Repository;

import org.springframework.data.repository.CrudRepository;

import com.app.climed.Entity.Agenda;

// Interface para representar o Repositorio da tabela Agenda
public interface AgendaRepository extends CrudRepository<Agenda, Integer>{
    
}

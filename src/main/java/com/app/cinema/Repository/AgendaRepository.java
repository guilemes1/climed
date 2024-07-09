package com.app.cinema.Repository;

import org.springframework.data.repository.CrudRepository;

//import com.app.cinema.Entity.CompositePremio;
import com.app.cinema.Entity.Agenda;

// Interface para representar o Repositorio da tabela Agenda
public interface AgendaRepository extends CrudRepository<Agenda, Integer>{
    
}

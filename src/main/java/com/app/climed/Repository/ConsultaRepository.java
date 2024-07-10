package com.app.climed.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.climed.Entity.Consulta;

import jakarta.persistence.Tuple;

// Interface para representar o Repositorio da tabela Consulta
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {

    // Consulta para retornar todas as consultas por ordem de data
    @Query(value = "SELECT a.id_consulta, b.nome_paciente, d.nome_especialidade, c.nome_medico, a.data, a.hora_inicio_consulta, a. hora_fim_consulta \n" + //
                "FROM consulta a\n" + //
                "INNER JOIN paciente b on a.id_paciente = b.id_paciente\n" + //
                "INNER JOIN medico c on a.id_medico = c.id_medico\n" + //
                "INNER JOIN especialidade d on a.id_especialidade = d.id_especialidade\n" + //
                "ORDER BY a.data;", nativeQuery = true)
    List<Tuple> listarConsultasClimed();

    // Consulta para retornar todas as consultas por dia especificado
    @Query(value = "SELECT a.id_consulta, b.nome_paciente, d.nome_especialidade, c.nome_medico, a.data, a.hora_inicio_consulta, a. hora_fim_consulta \n" + //
                "FROM consulta a\n" + //
                "INNER JOIN paciente b on a.id_paciente = b.id_paciente\n" + //
                "INNER JOIN medico c on a.id_medico = c.id_medico\n" + //
                "INNER JOIN especialidade d on a.id_especialidade = d.id_especialidade\n" + //
                "WHERE a.data = :date\n" + //
                "ORDER BY a.data;", nativeQuery = true)
    List<Tuple> listarConsultasPorDia(@Param("date") LocalDate date);

    // Consulta para retornar todas as consultas por especialidade especificada
    @Query(value = "SELECT a.id_consulta, b.nome_paciente, d.nome_especialidade, c.nome_medico, a.data, a.hora_inicio_consulta, a. hora_fim_consulta \n" + //
                "FROM consulta a\n" + //
                "INNER JOIN paciente b on a.id_paciente = b.id_paciente\n" + //
                "INNER JOIN medico c on a.id_medico = c.id_medico\n" + //
                "INNER JOIN especialidade d on a.id_especialidade = d.id_especialidade\n" + //
                "WHERE a.id_especialidade = :idEspecialidade\n" + //
                "ORDER BY a.data;", nativeQuery = true)
    List<Tuple> listarConsultasPorEspecialidade(@Param("idEspecialidade") Integer idEspecialidade);

    
}

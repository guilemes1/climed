package com.app.climed.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.climed.Entity.Medico;

import jakarta.persistence.Tuple;

// Interface para representar o Repositorio da tabela Medico
public interface MedicoRepository extends CrudRepository<Medico, Integer>{
    boolean existsByCrm(String crm);
    Optional<Medico> findByCrm(String crm);

    // Consulta para retornar os medicos com a especialidade determinada
    @Query(value = "SELECT a.id_medico, a.nome_medico, a.crm FROM medico a INNER JOIN exerce_esp b on a.id_medico = b.id_medico WHERE b.id_especialidade = :idEspecialidade ORDER BY a.id_medico", nativeQuery = true)
    List<Tuple> medicosEspecialistas(@Param("idEspecialidade") Integer idEspecialidade);
}

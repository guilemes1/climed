package com.app.climed.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// Classe para representar a tabela Medico
@Entity
@Getter
@Setter
public class Medico {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Medico", nullable = false)
    private Integer ID_Medico;

    @Column(name="Crm", nullable = false, length = 20)
    private String crm;

    @Column(name="NomeMedico", nullable = false, length = 100)
    private String nomeMedico;

    @Column(name="Telefone", nullable = true, length = 20)
    private String telefone;

    @Column(name="Percentual", nullable = true)
    private Double percentual;
}


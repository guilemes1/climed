package com.app.cinema.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Especialidade", nullable = false)
    private Integer ID_Especialidade;

    @Column(name="NomeEspecialidade", nullable = false, length = 100)
    private String nomeEspecialidade;

    @Column(name="Indice", nullable = false)
    private Integer indice;
}

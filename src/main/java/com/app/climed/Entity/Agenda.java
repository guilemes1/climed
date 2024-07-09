package com.app.climed.Entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// Classe para representar a tabela Premio
@Entity
@Getter
@Setter
public class Agenda {
    @Id // Chave primária composta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Agenda", nullable = false)
    private Integer ID_Agenda;

    @Enumerated(EnumType.STRING)
    @Column(name="DiaSemana", nullable = false, length = 30)
    private DiaSemana diaSemana;

    @Column(name="HoraInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name="HoraFim", nullable = false)
    private LocalTime horaFim;

    @Column(name="ID_Medico", nullable = false)
    private Integer ID_Medico;
}


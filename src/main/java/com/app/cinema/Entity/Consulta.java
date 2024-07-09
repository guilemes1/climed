package com.app.cinema.Entity;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

// Classe para representar a tabela Evento
@Entity
@Getter
@Setter
public class Consulta {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Consulta", nullable = false)
    private Integer ID_Consulta;

    @Column(name="ID_Medico", nullable = true)
    private Integer ID_Medico;

    @Column(name="ID_Especialidade", nullable = false)
    private Integer ID_Especialidade;

    @Column(name="ID_Paciente", nullable = false, length = 50)
    private Integer ID_Paciente;

    @Temporal(TemporalType.DATE)
    @Column(name="Data", nullable = true)
    private Date data;

    @Column(name="HoraInicioConsulta", nullable = false)
    private LocalTime horaInicioConsulta;

    @Column(name="HoraFimConsulta", nullable = true)
    private LocalTime horaFimConsulta;

    @Column(name="Pagou", nullable = false)
    private Boolean pagou;

    @Column(name="ValorPago", nullable = true)
    private Double valorPago;

    @Enumerated(EnumType.STRING)
    @Column(name="FormaDePagamento", nullable = true)
    private FormaDePagamento formaDePagamento;
}

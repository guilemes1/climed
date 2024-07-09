package com.app.cinema.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// Classe para representar a tabela Filme
@Entity
@Getter
@Setter
public class Paciente {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Paciente", nullable = false)
    private Integer ID_Paciente;

    @Column(name="Cpf", nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(name="NomePaciente", nullable = false, length = 255)
    private String nomePaciente;

    @Column(name="TelefonePaciente", nullable = false, length = 20)
    private String telefonePaciente;

    @Column(name="Endereco", nullable = true, length = 255)
    private String endereco;

    @Column(name="Idade", nullable = true)
    private Integer idade;

    @Column(name="Sexo", nullable = true, length = 50)
    private String sexo;
}

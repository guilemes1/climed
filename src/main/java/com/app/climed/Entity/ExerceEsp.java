package com.app.climed.Entity;

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
public class ExerceEsp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ExerceEsp", nullable = false)
    private Integer ID_ExerceEsp;

    @Column(name="ID_Medico", nullable = false)
    private Integer ID_Medico;

    @Column(name="ID_Especialidade", nullable = false)
    private Integer ID_Especialidade;
}

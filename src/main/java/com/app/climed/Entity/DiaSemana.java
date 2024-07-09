package com.app.climed.Entity;

public enum DiaSemana {
    SEGUNDA_FEIRA,
    TERCA_FEIRA,
    QUARTA_FEIRA,
    QUINTA_FEIRA,
    SEXTA_FEIRA,
    SABADO,
    DOMINGO;

    public static DiaSemana fromString(String dia) {
        switch (dia.toUpperCase()) {
            case "SEGUNDA-FEIRA":
                return SEGUNDA_FEIRA;
            case "TERÇA-FEIRA":
                return TERCA_FEIRA;
            case "QUARTA-FEIRA":
                return QUARTA_FEIRA;
            case "QUINTA-FEIRA":
                return QUINTA_FEIRA;
            case "SEXTA-FEIRA":
                return SEXTA_FEIRA;
            case "SÁBADO":
                return SABADO;
            case "DOMINGO":
                return DOMINGO;
            default:
                throw new IllegalArgumentException("Dia da semana inválido: " + dia);
        }
    }
}

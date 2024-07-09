package com.app.climed.Menus;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.climed.Repository.ConsultaRepository;

import jakarta.persistence.Tuple;

@Component
public class ListarConsultas extends Menu {

    private Boolean runApp = true;

    // Repositório para acessar a tabela Paciente
    @Autowired
    private ConsultaRepository consultaRepository;

    // Método para executar o menu de listagem de consultas
    @Override
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu de listagem de consultas
    @Override
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                return false;
            case 1:
                listarConsultas();
                return true;
            case 2:
                listarConsultasPorDiaEspecificado();
                return true;
            default:
                return true;
        }
    }

    // Método para listar consultas
    private void listarConsultas() {
        List<Tuple> consultas = consultaRepository.listarConsultasClimed();
        System.out.println("Listando todas as consultas ordenadas por data\n");
        System.out.println("ID | Nome paciente | Especialidade | Nome médico | Data | Hora inicio | Hora Fim");
        for (Tuple consulta : consultas) {
            System.out.println(consulta.get(0, Integer.class) + " | " + (consulta.get(1, String.class)) + " | " + (consulta.get(2, String.class)) + " | " + (consulta.get(3, String.class)) + " | " + (consulta.get(4, Date.class)) + " | " + (consulta.get(5, Time.class)) + " | " + (consulta.get(6, Time.class)));
        }
        System.out.print("\nPressione enter para continuar...");
        lerString();
    }

    private void listarConsultasPorDiaEspecificado() {
        System.out.print("Digite a data da consulta desejada no formato dd/MM/yyyy: ");
        LocalDate date = lerDate();
        List<Tuple> consultas = consultaRepository.listarConsultasPorDia(date);
        System.out.println("Listando todas as consultas ordenadas por data\n");
        System.out.println("ID | Nome paciente | Especialidade | Nome médico | Data | Hora inicio | Hora Fim");
        for (Tuple consulta : consultas) {
            System.out.println(consulta.get(0, Integer.class) + " | " + (consulta.get(1, String.class)) + " | " + (consulta.get(2, String.class)) + " | " + (consulta.get(3, String.class)) + " | " + (consulta.get(4, Date.class)) + " | " + (consulta.get(5, Time.class)) + " | " + (consulta.get(6, Time.class)));
        }
        System.out.print("\nPressione enter para continuar...");
        lerString();
    }

    // Método para mostrar as opções do menu de cadastro de pacientes
    @Override
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu de Listagem de Consultas!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Listar todas as Consultas");
        System.out.println("2 - Listar consultas por dia especificado");
        System.out.println("3 - Listar consultas por especialidade");
        System.out.println("0 - Voltar");
    }
    
}

package com.app.climed.Menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Classe para representar o menu principal
@Component
public class MainMenu extends Menu {

    private Boolean runApp = true;

    @Autowired
    private CadastrarMedico cadastrarMedico;

    @Autowired
    private CadastrarEspecialidade cadastrarEspecialidade;

    @Autowired
    private CadastrarPaciente cadastrarPaciente;

    @Autowired
    private CadastrarAgenda cadastrarAgenda;

    @Autowired
    private CadastrarConsulta cadastrarConsulta;

    // Método para executar o menu principal
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu principal
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                System.out.println("Saindo da aplicação...");
                return false;
            case 1:
                cadastrarMedico.runApp();
                return true;
            case 2:
                cadastrarPaciente.runApp();
                return true;
            case 3:
                cadastrarEspecialidade.runApp();
                return true;
            case 4:
                cadastrarAgenda.runApp();
                return true;
            case 5:
                cadastrarConsulta.runApp();
                return true;
            default:
                return true;
        }
    }

    // Método para mostrar as opções do menu principal
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu Principal da Aplicação Climed!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Medico");
        System.out.println("2 - Cadastrar Paciente");
        System.out.println("3 - Cadastrar Especialidade");
        System.out.println("4 - Cadastrar Agenda");
        System.out.println("5 - Cadastrar Consulta");
        System.out.println("8 - Listar Consultas");
        System.out.println("0 - Sair");
    }
}

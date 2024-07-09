package com.app.climed.Menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.climed.Entity.Paciente;
import com.app.climed.Repository.PacienteRepository;

// Classe para representar o menu de cadastro de filmes
@Component
public class CadastrarPaciente extends Menu {

    private Boolean runApp = true;

    // Repositório para acessar a tabela Paciente
    @Autowired
    private PacienteRepository pacienteRepository;

    // Método para executar o menu de cadastro de pacientes
    @Override
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu de cadastro de pacientes
    @Override
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                return false;
            case 1:
                cadastrarPaciente();
                return true;
            default:
                return true;
        }
    }

    // Método para cadastrar um paciente
    private void cadastrarPaciente() {
        Paciente paciente = new Paciente();
        System.out.print("Digite o nome do Paciente: ");
        paciente.setNomePaciente(lerString());
        System.out.print("Digite o CPF do Paciente: ");
        paciente.setCpf(lerString());
        System.out.print("Digite o telefone de contato do Paciente: ");
        paciente.setTelefonePaciente(lerString());
        try {
            pacienteRepository.save(paciente);
            System.out.println("Paciente cadastrado com sucesso!");
            System.out.print("Pressione Enter para continuar...");
            lerString();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar paciente!");
            System.out.print("Pressione Enter para continuar...");
            lerString();
        }
    }

    // Método para mostrar as opções do menu de cadastro de pacientes
    @Override
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu de Cadastro de Pacientes!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Paciente");
        System.out.println("0 - Voltar");
    }
    
}

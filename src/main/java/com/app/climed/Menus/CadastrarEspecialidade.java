package com.app.climed.Menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.climed.Entity.Especialidade;
import com.app.climed.Repository.EspecialidadeRepository;

@Component
public class CadastrarEspecialidade extends Menu {

    private Boolean runApp = true;

    // Repositório para acessar a tabela Especialidade
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    // Método para executar o menu de cadastro de pessoas
    @Override
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu de cadastro de especialidades
    @Override
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                return false;
            case 1:
                cadastrarEspecialidade();
                return true;
            default:
                return true;
        }
    }

    // Método para cadastrar uma especialidade
    private void cadastrarEspecialidade() {
        Especialidade especialidade = new Especialidade();
        System.out.print("Digite o nome da especialidade: ");
        String espec = lerString();
        espec = espec.toUpperCase().strip();
        especialidade.setNomeEspecialidade(espec);
        System.out.print("Digite o indice da especialidade: ");
        especialidade.setIndice(lerInteger());
        try {
            especialidadeRepository.save(especialidade);
            System.out.println("Especialidade cadastrada com sucesso!");
            System.out.print("Pressione enter para continuar...");
            lerString();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar especialidade!");
            System.out.print("Pressione enter para continuar...");
            lerString();
        }
    }

    // Método para mostrar as opções do menu de cadastro de especialidades
    @Override
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu de Cadastro de Especialidade!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Especialidade");
        System.out.println("0 - Voltar ao Menu Principal");
    }
    
}

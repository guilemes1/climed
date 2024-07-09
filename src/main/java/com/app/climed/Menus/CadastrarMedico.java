package com.app.climed.Menus;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.climed.Entity.Especialidade;
import com.app.climed.Entity.ExerceEsp;
import com.app.climed.Entity.Medico;
import com.app.climed.Repository.EspecialidadeRepository;
import com.app.climed.Repository.ExerceEspRepository;
import com.app.climed.Repository.MedicoRepository;

// Classe para representar o menu de cadastro de pessoas
@Component
public class CadastrarMedico extends Menu {

    private Boolean runApp = true;

    // Repositório para acessar a tabela Pessoa
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private ExerceEspRepository exerceEspRepository;

    public Integer buscarIdPorCrm(String crm) {
        Optional<Medico> medico = medicoRepository.findByCrm(crm);
        return medico.map(Medico::getID_Medico).orElse(null);
    }

    public Integer buscarIdPorEspecialidade(String esp) {
        Optional<Especialidade> especialidade = especialidadeRepository.findByNomeEspecialidade(esp);
        return especialidade.map(Especialidade::getID_Especialidade).orElse(null);
    }

    // Método para executar o menu de cadastro de pessoas
    @Override
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu de cadastro de pessoas
    @Override
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                return false;
            case 1:
                cadastrarMedico();
                return true;
            default:
                return true;
        }
    }

    // Método para cadastrar uma pessoa
    private void cadastrarMedico() {
        Medico medico = new Medico();
        System.out.print("Digite o nome medico: ");
        medico.setNomeMedico(lerString());
        System.out.print("Digite o CRM: ");
        String crm = lerString();
        medico.setCrm(crm);
        medicoRepository.save(medico);
        
        Integer idMedico = buscarIdPorCrm(crm);

        boolean possueEspecialidade = true;

        while (possueEspecialidade) {
            ExerceEsp exerceEsp = new ExerceEsp();
            System.out.print("Digite a Especialidade: ");
            String especialidade = lerString();
            especialidade = especialidade.toUpperCase().strip();

            Integer idEspecialidade = buscarIdPorEspecialidade(especialidade);
        
            if (idEspecialidade == null) {
                System.out.println("Especialidade não encontrada, faça o cadastro anteriormente!");
                System.out.print("Pressione enter para continuar...");
                lerString();
                return;
            } else {
                exerceEsp.setID_Medico(idMedico);
                exerceEsp.setID_Especialidade(idEspecialidade);
                exerceEspRepository.save(exerceEsp);
                System.out.print("Possui mais alguma especialidade? (Sim - 1 | Não - 0): ");
                possueEspecialidade = lerBoolean();
            }
        }

        try {
            //medicoRepository.save(medico);
            System.out.println("Medico cadastrado com sucesso!");
            System.out.print("Pressione enter para continuar...");
            lerString();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar medico!");
            System.out.print("Pressione enter para continuar...");
            lerString();
        }
    }

    // Método para mostrar as opções do menu de cadastro de pessoas
    @Override
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu de Cadastro de Medico!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Medico");
        System.out.println("0 - Voltar ao Menu Principal");
    }
}

package com.app.climed.Menus;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.climed.Entity.Agenda;
import com.app.climed.Entity.Medico;
import com.app.climed.Repository.AgendaRepository;
import com.app.climed.Repository.MedicoRepository;

// Classe para representar o menu de cadastro de prêmios
@Component
public class CadastrarAgenda extends Menu {

    private Boolean runApp = true;

    // Repositório para acessar a tabela Premio
    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public Integer buscarIdPorCrm(String crm) {
        Optional<Medico> medico = medicoRepository.findByCrm(crm);
        return medico.map(Medico::getID_Medico).orElse(null);
    }

    // Método para executar o menu de cadastro de prêmios
    @Override
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu de cadastro de prêmios
    @Override
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                return false;
            case 1:
                cadastrarAgenda();
                return true;
            default:
                return true;
        }
    }

    // Método para cadastrar um prêmio
    private void cadastrarAgenda() {
        Agenda agenda = new Agenda();
        System.out.print("Digite o CRM do médico: ");
        String crm = lerString();

        if (medicoRepository.existsByCrm(crm)) {
            Integer idMedico = buscarIdPorCrm(crm);
            agenda.setID_Medico(idMedico);
        }
        else {
            System.out.println("CRM do médico não encontrado");
            System.out.print("Pressione Enter para continuar...");
            lerString();
            return;
        }

        System.out.print("Digite o dia da semana (ex: Segunda): ");
        agenda.setDiaSemana(lerDiaSemana());
        System.out.print("Digite o horário de inicio do expediente neste dia no formato hh:mm:ss: ");
        agenda.setHoraInicio(lerLocalTime());
        System.out.print("Digite o horário fim no expediente neste dia no formato hh:mm:ss: ");
        agenda.setHoraFim(lerLocalTime());
        try {
            agendaRepository.save(agenda);
            System.out.println("Agenda do médico cadastrada com sucesso!");
            System.out.print("Pressione Enter para continuar...");
            lerString();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Agenda!");
            System.out.print("Pressione Enter para continuar...");
            lerString();
        }
    }

    // Método para mostrar as opções do menu de cadastro de prêmios
    @Override
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu para casdastrar a Agenda (Expediente) de trabalho dos médicos!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Agenda");
        System.out.println("0 - Voltar");
    }
    
}

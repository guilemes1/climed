package com.app.climed.Menus;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.climed.Entity.Consulta;
import com.app.climed.Entity.Especialidade;
import com.app.climed.Entity.Paciente;
import com.app.climed.Repository.ConsultaRepository;
import com.app.climed.Repository.EspecialidadeRepository;
import com.app.climed.Repository.MedicoRepository;
import com.app.climed.Repository.PacienteRepository;

import jakarta.persistence.Tuple;

// Classe para representar o menu de cadastro de consultas
@Component
public class CadastrarConsulta extends Menu {

    private Boolean runApp = true;

    // Repositório para acessar a tabela Evento
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public Integer buscarIdPorCpf(String cpf) {
        Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
        return paciente.map(Paciente::getID_Paciente).orElse(null);
    }

    public Integer buscarIdPorEspecialidade(String esp) {
        Optional<Especialidade> especialidade = especialidadeRepository.findByNomeEspecialidade(esp);
        return especialidade.map(Especialidade::getID_Especialidade).orElse(null);
    }

    // Método para executar o menu de cadastro de consultas
    @Override
    public void runApp() {
        while (runApp) {
            limparTela();
            runApp = menuDeOpcoes();
        }
    }

    // Método para executar o menu de opções do menu de cadastro de consultas
    @Override
    protected Boolean menuDeOpcoes() {
        mostrarOpcoes();
        Integer opcao = lerOpcao();
        switch (opcao) {
            case 0:
                return false;
            case 1:
                cadastrarConsulta();
                return true;
            default:
                return true;
        }
    }

    // Método para cadastrar uma consulta
    private void cadastrarConsulta() {
        Consulta consulta = new Consulta();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = lerString();

        Integer idPaciente = buscarIdPorCpf(cpf);

        if (idPaciente == null) {
            System.out.println("Paciente não encontrado, faça o cadastro anteriormente!");
            System.out.print("Pressione enter para continuar...");
            lerString();
            return;
        } else {
            consulta.setID_Paciente(idPaciente);
        }

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
            consulta.setID_Especialidade(idEspecialidade);
        }

        System.out.println("Selecione o ID do médico especialista:\n");
        List<Tuple> medicosEspecialistas = medicoRepository.medicosEspecialistas(idEspecialidade);
        //System.out.println("Listando os Atores nominados e premiados pelo premio " + premio + ":\n");
        System.out.println("ID do médico | Nome do Médico | CRM");
        for (Tuple medico : medicosEspecialistas) {
            System.out.println(medico.get(0, Integer.class) + " | " + (medico.get(1, String.class)) + " | " + (medico.get(2, String.class)));
        }

        Integer idMedico = lerInteger();
        consulta.setID_Medico(idMedico);

        System.out.print("Digite a data da consulta no formato dd/MM/yyyy: ");
        consulta.setData(lerDate());

        System.out.print("Digite o horário de inicio da consulta no formato hh:mm:ss: ");
        consulta.setHoraInicioConsulta(lerLocalTime());

        System.out.print("Digite se a consulta foi paga: (1 - Sim | 0 - Não): ");
        Boolean pagou = lerBoolean();
        consulta.setPagou(pagou);

        if (pagou) {
            System.out.print("Digite a forma de pagamento: ");
            consulta.setFormaDePagamento(lerFormaDePagamento());

            System.out.print("Digite o valor pago: ");
            consulta.setValorPago(lerDouble());
        }

        try {
            consultaRepository.save(consulta);
            System.out.println("Consulta cadastrada com sucesso!");
            System.out.print("Pressione enter para continuar...");
            lerString();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar constulta!");
            System.out.print("Pressione enter para continuar...");
            lerString();
        }
    }

    // Método para mostrar as opções do menu de cadastro de consultas
    @Override
    protected void mostrarOpcoes() {
        System.out.println("Bem vindo ao Menu de Cadastro de Consultas!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Consulta");
        System.out.println("0 - Voltar");
    }
    
}

package com.app.climed.Menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import com.app.climed.ClimedApplication;
import com.app.climed.Entity.DiaSemana;
import com.app.climed.Entity.FormaDePagamento;

// Classe abstrata para representar um menu
public abstract class Menu {

    abstract public void runApp();

    abstract protected Boolean menuDeOpcoes();

    // Método para ler a opção do usuário
    protected Integer lerOpcao() {
        // Lê entrada do usuario
        Scanner scanner = ClimedApplication.getScanner();
        try {
            Integer opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (Exception e) {
            return -1;
        }
    }

    // Método para ler a string do usuário
    protected String lerString() {
        // Lê entrada do usuario
        Scanner scanner = ClimedApplication.getScanner();
        try {
            String string = scanner.nextLine();
            return string;
        } catch (Exception e) {
            System.out.println("Erro ao ler string!");
            return null;
        }
    }

    // Método para ler o inteiro do usuário
    protected Integer lerInteger() {
        // Lê entrada do usuario
        Scanner scanner = ClimedApplication.getScanner();
        try {
            Integer integer = Integer.parseInt(scanner.nextLine());
            return integer;
        } catch (Exception e) {
            System.out.println("Erro ao ler inteiro!");
            return null;
        }
    }

    // Método para ler o double do usuário
    protected Double lerDouble() {
        // Lê entrada do usuario
        Scanner scanner = ClimedApplication.getScanner();
        try {
            Double double1 = Double.parseDouble(scanner.nextLine());
            return double1;
        } catch (Exception e) {
            System.out.println("Erro ao ler double!");
            return null;
        }
    }

    // Método para ler o boolean do usuário
    protected Boolean lerBoolean() {
        // Lê entrada do usuario
        Scanner scanner = ClimedApplication.getScanner();
        String input = scanner.nextLine();
        try {
            Boolean boolean1;
            if (input.equals("1")) {
                boolean1 = true;
            } else if (input.equals("0")) {
                boolean1 = false;
            } else {
                throw new IllegalArgumentException("Entrada inválida. Por favor, insira 1 ou 0.");
            }
            return boolean1;
        } catch (Exception e) {
            System.out.println("Erro ao ler boolean!");
            return null;
        }
    }

    // Método para ler um LocalTime do usuário
    protected LocalTime lerLocalTime() {
        // Formato esperado: HH:mm:ss (exemplo: 13:45:00)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Scanner scanner = ClimedApplication.getScanner();
        try {
            String input = scanner.nextLine();
            LocalTime time = LocalTime.parse(input, formatter);
            return time;
        } catch (DateTimeParseException e) {
            System.out.println("Formato de horário inválido! Por favor, use o formato HH:mm:ss.");
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao ler horário!");
            return null;
        }
    }

    // Método para ler um Date do usuário
    protected Date lerDate() {
        // Formato esperado: dd/MM/yyyy (exemplo: 25/12/2023)
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = ClimedApplication.getScanner();
        try {
            String input = scanner.nextLine();
            formatter.setLenient(false);
            Date date = formatter.parse(input);
            return date;
        } catch (ParseException e) {
            System.out.println("Formato de data inválido! Por favor, use o formato dd/MM/yyyy.");
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao ler data!");
            return null;
        }
    }    

    // Método para ler um DiaSemana do usuário
    protected DiaSemana lerDiaSemana() {
        //System.out.print("Digite um dia da semana (ex: Segunda-feira): ");
        Scanner scanner = ClimedApplication.getScanner();
        try {
            String input = scanner.nextLine();
            DiaSemana dia = DiaSemana.valueOf(input.toUpperCase());
            return dia;
        } catch (IllegalArgumentException e) {
            System.out.println("Dia da semana inválido! Por favor, insira um valor válido.");
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao ler dia da semana!");
            return null;
        }
    }

    // Método para ler uma FormaDePagamento do usuário
    protected FormaDePagamento lerFormaDePagamento() {
        //System.out.print("Digite um dia da semana (ex: Segunda-feira): ");
        Scanner scanner = ClimedApplication.getScanner();
        try {
            String input = scanner.nextLine();
            FormaDePagamento pagamento = FormaDePagamento.valueOf(input.toUpperCase().strip());
            return pagamento;
        } catch (IllegalArgumentException e) {
            System.out.println("Forma de pagamento inválida! Por favor, insira um valor válido (Debito, Credito, Pix, Dinheiro).");
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao ler dia da semana!");
            return null;
        }
    }

    // Método para mostrar as opções do menu
    abstract protected void mostrarOpcoes();

    // Método para limpar a tela
    protected static void limparTela() {
        // Detecta o Sistema Operacional
        String os = System.getProperty("os.name").toLowerCase();
        // Seleciona o comando para limpar a tela
        String comandoLimparTela = os.contains("windows") ? "cls" : "clear";
        // Executa o comando para limpar a tela
        try {
            new ProcessBuilder(comandoLimparTela).inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao limpar tela!");
        }
    }
}

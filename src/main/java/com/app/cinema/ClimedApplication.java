package com.app.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import com.app.cinema.Menus.MainMenu;
import java.util.Scanner;

// Classe para representar a aplicação
@SpringBootApplication
public class ClimedApplication {

	// Scanner para ler dados do teclado
	public static final Scanner scanner = new Scanner(System.in);

	// Menu principal
	@Autowired
	private MainMenu mainMenu;

	// Método para executar a aplicação
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ClimedApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

	// Método para retornar o scanner
	public static Scanner getScanner() {
		return scanner;
	}

	// Método para executar o menu principal
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		mainMenu.runApp();
		scanner.close();
	}

}

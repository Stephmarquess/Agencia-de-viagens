package com.GoTour.Menu;

import java.util.Scanner;

public class MenuIO {


	public static int menu(Scanner scanner) {
		System.out.println("Escolha uma opcao: "
		+ "1 - Cliente\n" + "2 - Destino \n" + "3 - Reserva \n" + "4 - Atendimento\n" + "5 - Sair");
		
		
		return scanner.nextInt();
		
	}
		
}

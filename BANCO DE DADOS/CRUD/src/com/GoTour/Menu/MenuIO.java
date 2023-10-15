package com.GoTour.Menu;

import java.util.Scanner;

public class MenuIO {


	public static int menu(Scanner scanner) {
		System.out.println("::::::::::::::::: MENU - GOTOUR :::::::::::::::::::::::");
		System.out.println(" ");
		System.out.println("Escolha uma opcão: \n "
		+ " \n 1 - Cliente\n" + " 2 - Destino \n" + " 3 - Reserva \n"  + " 9 - Sair");
		System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::");
		
		return scanner.nextInt();
		
	}
		
}

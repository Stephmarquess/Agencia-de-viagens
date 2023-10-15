package com.GoTour.Menu;

import java.util.Scanner;

public class MenuIO {


	public static int menu(Scanner scanner) {
		System.out.println("::::::::::::::::: GO TOUR :::::::::::::::::::::::");
		System.out.println("");
		System.out.println("Escolha uma opcão: \n "
		+ " \n 1 - Cliente\n" + " 2 - Destino \n" + " 3 - Reserva \n"  + " 0 - Sair");
		System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::");
		
		return scanner.nextInt();
		
	}
		
}

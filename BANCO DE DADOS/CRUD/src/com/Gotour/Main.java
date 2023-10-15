package com.Gotour;

import java.util.Scanner;

import com.GoTour.Menu.BookingIO;
import com.GoTour.Menu.ClientIO;
import com.GoTour.Menu.DestinationIO;
import com.GoTour.Menu.MenuIO;

public class Main {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

			int option = 0;

			do {

				option = MenuIO.menu(scanner);

				switch (option) {
				case 1:
					ClientIO.SubMenuCli(scanner);
					break;
				case 2:
					DestinationIO.SubMenuDestination(scanner);
					break;
				case 3:
					BookingIO.SubMenuBooking(scanner);
					break;
				case 4:
	//				AtendimentoIO.SubMenuAtendimento(scanner);
					break;
				default:
					System.out.println("Digite uma opcao valida!");

				}

			} while (option != 5);
			scanner.close();
		
	}


}

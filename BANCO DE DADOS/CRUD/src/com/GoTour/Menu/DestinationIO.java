package com.GoTour.Menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Gotour.database.DatabaseConnection;
import com.Gotour.model.Destination;
import com.GoTour.dao.DestinationDAO;

public class DestinationIO {

	static Connection connection = DatabaseConnection.createConnection();
	static DestinationDAO destinationDAO = new DestinationDAO(connection);

	public static int SubMenuDestination(Scanner scanner) {
		int input = Integer.MAX_VALUE;
		
		
		do {
			System.out.println(" DESTINO \n" + "1 - Cadastrar Destino \n" + "2 - Consultar Destinos \n" + "3 - Atualizar Destino \n" + "4 - Deletar Destino"
					+ "\n 0 - Sair");

			input = scanner.nextInt();
			
			switch (input) {
			case 1:
				scanner.nextLine();
				
				Destination destination = new Destination();
								
				System.out.println("Nome do destino");
				destination.setNomeDestino(scanner.nextLine());
				System.out.println("Descricao do destino: ");
				destination.setDescricaoDestino(scanner.nextLine());
				
				destinationDAO.createDestination(destination);
				
				
				break;
			
			case 2:
				destinationDAO.readAllDestinations();

				break;
			
			case 3:
				
				Destination updateDestination = new Destination();				
				scanner.nextLine();
				System.out.println("Digite o ID do Destino que deseja atualizar: ");				
				updateDestination.setIdDestino(scanner.nextInt());												
				System.out.println("Nome do destino: ");				
				updateDestination.setNomeDestino(scanner.nextLine());
				scanner.nextLine();
				System.out.println("Descrição destino: ");
				updateDestination.setDescricaoDestino(scanner.nextLine());				
				
				
				destinationDAO.updateDestination(updateDestination);

				break;
			case 4:
				System.out
						.println("Digite o ID do Destino a ser " + "DELETADO");
				int idDestination = scanner.nextInt();
				
				destinationDAO.deleteDestination(idDestination);
				
				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (input != 0);
		
		return input;
	}

	
	
}

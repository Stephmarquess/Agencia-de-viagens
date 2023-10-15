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
			System.out.println(" \n::::::::: ÁREA DESTINO ::::::::: \n ");
			System.out.println(" 1 - Cadastrar Destino \n" + " 2 - Consultar Destino \n" + " 3 - Atualizar Destino \n"
					+ " 4 - Deletar Destino" + "\n 0 - Voltar \n");
			System.out.println(":::::::::::::::::::::::::::::::: \n ");
			input = scanner.nextInt();

			switch (input) {
			case 1:
				scanner.nextLine();

				Destination destination = new Destination();
				System.out.println("--------------------------------------------");
				System.out.println("Destinos: CADASTRAR DESTINO");
				System.out.println("-------------------------------------------- \n");
				
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
				System.out.println("--------------------------------------------");
				System.out.println("Destino: ATUALIZAR DESTINO");
				System.out.println("-------------------------------------------- \n");
				
				Destination updateDestination = new Destination();
				
				System.out.println("Digite o ID do Destino que deseja ATUALIZAR: ");
				updateDestination.setIdDestino(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome do destino: ");
				updateDestination.setNomeDestino(scanner.nextLine());
				
				System.out.println("Descrição destino: ");
				updateDestination.setDescricaoDestino(scanner.nextLine());

				destinationDAO.updateDestination(updateDestination);

				break;
			case 4:
				System.out.println("--------------------------------------------");
				System.out.println("Destino: DELETAR DESTINO");
				System.out.println("-------------------------------------------- \n");

				System.out.println("Digite o ID do destino a ser (DELETADO) ");
				
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

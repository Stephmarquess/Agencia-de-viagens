package com.GoTour.Menu;

import java.sql.Connection;
import java.util.Scanner;

import com.GoTour.dao.ClientDAO;
import com.Gotour.database.DatabaseConnection;
import com.Gotour.model.Client;

public class ClientIO {

	static Connection connection = DatabaseConnection.createConnection();
	static ClientDAO clientDAO = new ClientDAO(connection);

	public static int SubMenuCli(Scanner scanner) {
		int input = Integer.MAX_VALUE;
		
		
		do {
			System.out.println("MENU CLIENTE\n" + "1 - cadastrar\n" + "2 - Consultar Dados \n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			input = scanner.nextInt();
			switch (input) {
			case 1:
				scanner.nextLine();
				Client client = new Client();
				System.out.println("Nome Completo: ");
				client.setNomeCliente(scanner.nextLine());
				System.out.println("CPF: ");
				client.setCpf(scanner.next().trim());
				scanner.nextLine();
				System.out.println("Endereco: ");
				client.setEndereco(scanner.nextLine());
				System.out.println("Telefone: ");
				client.setTelefone(scanner.next().trim());
				System.out.println("E-mailL: ");
				client.setEmail(scanner.nextLine());
				
				
				clientDAO.createClient(client);
				
				break;
			case 2:
				clientDAO.readAllClients();
				break;
			case 3:
				Client updateClient = new Client();
				System.out.println("Digite o ID do cliente a ser atualizado: ");
				updateClient.setIdCliente(scanner.nextInt());				
				scanner.nextLine();
				System.out.println("Nome Completo: ");
				updateClient.setNomeCliente(scanner.nextLine());
				
				System.out.println("CPF: ");
				updateClient.setCpf(scanner.nextLine().trim());
	
				System.out.println("Endereco: " + "(Rua, nº , bairro, Cidade, UF. País)");
				updateClient.setEndereco(scanner.nextLine());
	
				System.out.println("Telefone: ");
				updateClient.setTelefone(scanner.next().trim());
				
				System.out.println("E-mail: ");
				updateClient.setEmail(scanner.nextLine());


				clientDAO.updateClient(updateClient);

				break;
			case 4:
				System.out
						.println("Digite o ID do Cliente a ser " + "DELETADO");
				int idCliente = scanner.nextInt();
				clientDAO.deleteClient(idCliente);
				
				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (input != 0);
		
		return input;
	}

	
	
}

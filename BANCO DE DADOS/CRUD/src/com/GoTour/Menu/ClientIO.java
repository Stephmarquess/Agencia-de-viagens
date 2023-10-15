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
			System.out.println(" \n::::::::: ÁREA CLIENTE ::::::::: \n ");
			System.out.println(" 1 - Cadastrar Cliente \n" + " 2 - Consultar Cliente \n" + " 3 - Atualizar Cliente \n"
					+ " 4 - Deletar Cliente" + "\n 0 - Voltar \n");
			System.out.println(":::::::::::::::::::::::::::::::: \n ");
			input = scanner.nextInt();
			switch (input) {
			case 1:
				scanner.nextLine();
				Client client = new Client();
				System.out.println("");
				System.out.println("--------------------------------------------");
				System.out.println("Cliente: CADASTRAR CLIENTE");
				System.out.println("--------------------------------------------");
				System.out.println("Nome Completo: ");
				client.setNomeCliente(scanner.nextLine());
				System.out.println("CPF: ");
				client.setCpf(scanner.next().trim());
				scanner.nextLine();
				System.out.println("Endereco (Rua, nº , bairro , Cidade , UF, País): ");
				client.setEndereco(scanner.nextLine());
				System.out.println("Telefone (com DDD):  ");
				client.setTelefone(scanner.next().trim());
				scanner.nextLine();
				System.out.println("E-mail: ");
				client.setEmail(scanner.nextLine());

				clientDAO.createClient(client);

				break;
			case 2:
				clientDAO.readAllClients();
				break;
			case 3:
				
				System.out.println("--------------------------------------------");
				System.out.println("Cliente: ATUALIZAR CLIENTE");
				System.out.println("--------------------------------------------");
				
				Client updateClient = new Client();
				
				System.out.println("Digite o ID do cliente a ser ATUALIZADO: ");
				updateClient.setIdCliente(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome completo");
				updateClient.setNomeCliente(scanner.nextLine());				
				System.out.println("CPF: ");
				updateClient.setCpf(scanner.nextLine());				
				System.out.println("Endereço (Rua, nº , bairro, cidade, UF , país): ");				
				updateClient.setEndereco(scanner.nextLine());				
				System.out.println("Telefone: ");
				updateClient.setTelefone(scanner.nextLine());
				System.out.println("E-mail: ");
				updateClient.setEmail(scanner.nextLine());
	
				clientDAO.updateClient(updateClient);
				
				break;
			case 4:
				System.out.println("");
				System.out.println("--------------------------------------------");
				System.out.println("Cliente: DELETAR CLIENTE");
				System.out.println("--------------------------------------------");
				System.out.println("Digite o ID do Cliente a ser " + "(DELETADO)");
				int idCliente = scanner.nextInt();
				clientDAO.deleteClient(idCliente);

				break;
			default:
				System.out.println(" ");
				
			}

		} while (input != 0);

		return input;
	}

}

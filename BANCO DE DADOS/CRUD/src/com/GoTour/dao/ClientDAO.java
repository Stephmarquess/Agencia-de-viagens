package com.GoTour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Gotour.model.Client;

public class ClientDAO {

	private static String sql;

	private final Connection connection;

	public ClientDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE

	public void createClient(Client client) {
		sql = "INSERT INTO Cliente (nomeCliente, cpf, endereco, telefone, email) "
				+ "VALUES (?, ? , ? , ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, client.getNomeCliente());
			stmt.setString(2, client.getCpf());
			stmt.setString(3, client.getEndereco());
			stmt.setString(4, client.getTelefone());
			stmt.setString(5, client.getEmail());

			stmt.executeUpdate();

			System.out.println("");
			System.out.println("Cliente cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar Cliente");
			System.out.println(e.getMessage());
		}
	}

	// READ

	public void readAllClients() {
		sql = "SELECT * FROM Cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Client cliente = new Client();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpf(r.getString("cpf"));
				cliente.setEndereco(r.getString("endereco"));
				cliente.setTelefone(r.getString("telefone"));
				cliente.setEmail(r.getString("email"));

				System.out.println("----------------------------------------------");
				System.out.printf(
						"\n Nome: %s\n CPF: %s\n Endereço: %s\n Telefone: %s\n E-mail: %s\n Id: "
								+ cliente.getIdCliente(),
						cliente.getNomeCliente(), cliente.getCpf(), cliente.getEndereco(), cliente.getTelefone(),
						cliente.getEmail());
				System.out.println(" ");
			}

		} catch (SQLException e) {
			System.out.println("Não foi possível carregar as informações de Cliente");
			System.out.println("Mensagem" + e.getMessage());
		}

	}

	// UPDATE

	public void updateClient(Client client) {
		sql = "UPDATE Cliente SET nomeCliente = ?, cpf =?, endereco =?, telefone =?, email =? WHERE idCliente =?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, client.getNomeCliente());
			stmt.setString(2, client.getCpf());
			stmt.setString(3, client.getEndereco());
			stmt.setString(4, client.getTelefone());
			stmt.setString(5, client.getEmail().toString());
			stmt.setInt(6, client.getIdCliente());

			stmt.executeUpdate();
			
			System.out.println("Cliente atualizado com sucesso! \n");
			System.out.println(" Nome do Cliente: "
					+ client.getNomeCliente() + "\n CPF: " + client.getCpf() + "\n Endereço: "
					+ client.getEndereco() + "\n Telefone: " + client.getTelefone()  + "\n E-mail: " + client.getEmail());

		} catch (SQLException e) {
			System.out.println("Não foi possível atualizar o cliente especificado: \n " + e.getMessage());
		}
	}

	// DELETE

	public void deleteClient(int id) {
		sql = "DELETE FROM Cliente WHERE idCliente = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();

			System.out.println("");
			System.out.println("Cliente deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Não foi possível deletar o cliente especificado");
			System.out.println(e.getMessage());
		}
	}
}

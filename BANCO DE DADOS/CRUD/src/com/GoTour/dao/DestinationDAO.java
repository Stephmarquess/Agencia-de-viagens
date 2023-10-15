package com.GoTour.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Gotour.model.Destination;

public class DestinationDAO {

	private static String sql;

	private final Connection connection;
//	
	public DestinationDAO (Connection connection) {
		this.connection = connection;
	}

	// CREATE 
	
	public void createDestination(Destination destination) {
		sql = "INSERT INTO Destino (nomeDestino, descricaoDestino) VALUES (?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
		
			stmt.setString(1, destination.getNomeDestino());
			stmt.setString(2, destination.getDescricaoDestino());
			
			stmt.executeUpdate();
			
			System.out.println("Destino cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar Destino");
			System.out.println(e.getMessage());
		}
	}
	
	// READ 
	
		public void readAllDestinations () {
			sql = "SELECT * FROM Destino";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				ResultSet r = stmt.executeQuery();
				
				
				while(r.next()) {
					Destination destination = new Destination();
				
					destination.setIdDestino(r.getInt("idDestino"));
					destination.setNomeDestino(r.getString("nomeDestino"));
					destination.setDescricaoDestino(r.getString("descricaoDestino"));
									
					
					System.out.println("--------------------------------------------");
					
					System.out.printf("\n Nome do Destino: %s\n Descrição: %s\n ID: " +
					destination.getIdDestino(), destination.getNomeDestino(), destination.getDescricaoDestino());
					System.out.println(" ");
				}
				
				
			} catch (SQLException e) {
				System.out.println("Não foi possível carregar as informações do Destino");
				System.out.println("Mensagem" + e.getMessage());
			}
			
		}
			

		// UPDATE
		
		public void updateDestination(Destination destination) {
			sql = "UPDATE Destino SET nomeDestino = ?, descricaoDestino = ? "
					+ "WHERE idDestino = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {				
												
				stmt.setString(1, destination.getDescricaoDestino());
				stmt.setString(2, destination.getNomeDestino());				
				stmt.setInt(3, destination.getIdDestino());
				
				
				stmt.executeUpdate();
				
				System.out.print("Destino alterado com sucesso! \n");
				
				System.out.println(" \n Nome do Destino: "
						+ destination.getNomeDestino() + "\n Descrição do destino: " + destination.getDescricaoDestino() + 
						" \n Id destino: " + destination.getIdDestino());
					
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		// DELETE 

		public void deleteDestination (int id) {
			sql = "DELETE FROM Destino WHERE idDestino = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				stmt.setInt(1, id); 
				
				stmt.executeUpdate();
				
				System.out.println("Destino deletado com sucesso!");
			} catch (SQLException e ) {
				System.out.println("Não foi possível deletar o destino especificado");
				System.out.println(e.getMessage());
			}
		}
	
	
}


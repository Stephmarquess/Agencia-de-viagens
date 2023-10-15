package com.Gotour.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

	private static final String url = "jdbc:mysql://localhost:3306/agenciaGoTour";
	private static final String user = "root"; 
	private static final String password = "root";
	
	public static Connection createConnection () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("");
			System.out.println("Driver encontrado!");
			System.out.println("");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado! Mensagem:" + e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("");
			System.out.println("Driver conectado com sucesso!");
			System.out.println("");
			
			return connection; 
			
		} catch (SQLException e) {
			System.out.println("Driver não encontrado! Mensagem:" + e.getMessage());
			return null;
		}
	}
	
}

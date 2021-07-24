package com.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private ConnectionFactory() {
		throw new UnsupportedOperationException();
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String driver = "postgresql";
		String dataBaseAddress = "localhost";
		String dataBaseName = "bootcamp_santander";
		String user = "postgres";
		String password = "toqweb18";
		
		
		//Construindo uma String de conexão
		StringBuilder sb = new StringBuilder("jdbc:")
				.append(driver).append("://")
				.append(dataBaseAddress).append("/")
				.append(dataBaseName);
		
		String connectionUrl = sb.toString();
		
		//Criando conexão com o banco de dados
		try {
			conn = DriverManager.getConnection(connectionUrl, user, password);
		} catch (SQLException e) {
			System.out.println("Falha ao conectar no banco de dados!");
			throw new RuntimeException(e);
		}
		
		return conn;
	}
	
}

package br.com.fadergswebii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public static Connection getConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aulaDB","postgres","fadergs");
			
		}
			catch (SQLException e)
			{
				System.out.println("Falha e conexão!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver não encontrado!");
			}

		return con;
		
	}
	
}

package br.com.fadergswebii.objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import br.com.fadergswebii.jdbc.Conexao;

public class usuarioDAO {
	
	Scanner teclado = new Scanner(System.in);
	private Connection con = Conexao.getConnection();
	
	public void cadastrar (usuario usuario)
	{
		String sql = "INSERT INTO usuario (nome,senha,login) values (?,?,?)";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSenha());
			preparador.setString(3, usuario.getLogin());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar (usuario usuario)
	{ 
		String sql = "UPDATE usuario  SET(nome,senha,login) WHERE (nome,senha,login)";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSenha());
			preparador.setString(3, usuario.getLogin());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		/*String novoNome;
		int id;
		
		System.out.println(" Digite o ID do usuario: ");
		id = teclado.nextInt();
		System.out.println(" Digite o novo nome: ");
		novoNome = teclado.next();
		
		//Trocar a coluna nome pela string nome
		//onde a linha tenha coluna id  igual a int id
		
		//String sql = "UPDATE usuario  SET nome='NOVO' WHERE id='5'";
		String sql = "UPDATE usuario  SET nome=(?) WHERE id=(?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, novoNome);
			preparador.setInt(2, id);
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	
	public void deletar()
	{
		int id;
		
		System.out.println(" Digite o ID do usuario: ");
		id = teclado.nextInt();
		
		String sql = "DELETE FROM usuario WHERE id=(?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<usuario> buscar(){
		
		String sql = "SELECT * FROM usuario";
		List<usuario> lista = new ArrayList<usuario>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			
			ResultSet rs = preparador.executeQuery();
			while(rs.next()){
				usuario usu = new usuario();
				
				usu.setId(rs.getInt("id"));
				usu.setNome(rs.getString("nome"));
				usu.setLogin(rs.getString("login"));
				usu.setSenha(rs.getString("senha"));
				
				lista.add(usu);
			}
			
			preparador.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}
	
	
	
	public void deletarTudo()
	{
		String sql = "TRUNCATE TABLE usuario";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



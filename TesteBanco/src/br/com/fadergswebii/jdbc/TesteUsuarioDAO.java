package br.com.fadergswebii.jdbc;

import java.util.List;
import java.util.Scanner;

import br.com.fadergswebii.objetos.usuario;
import br.com.fadergswebii.objetos.usuarioDAO;

public class TesteUsuarioDAO {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int escolha = 0;
		usuarioDAO usuDao = new usuarioDAO();
		
		do {
			System.out.println(" --- MENU --- "
					+ " \n1 - Cadastrar"
					+ " \n2 - Editar"
					+ " \n3 - Deletar"
					+ " \n4 - Buscar"
					+ " \n5 - Limpar tudo"
					+ " \n0 - Sair");
			
			escolha = teclado.nextInt();
			
			
			switch (escolha)
			{
				case 1:
					System.out.println(" -- CADASTRO DE USUARIO -- ");
					usuario usu = new usuario();
					System.out.println("Digite o nome:");
					String nome = teclado.next();
					usu.setNome(nome);
					System.out.println("Digite a senha:");
					String senha = teclado.next();
					usu.setSenha(senha);
					System.out.println("Digite o login:");
					String login = teclado.next();
					usu.setLogin(login);
					usuDao.cadastrar(usu);
				break;
				case 2:
					System.out.println(" -- EDITAR USUARIO -- ");
					
					//usuDao.editar();
					break;
				case 3:
					System.out.println(" -- DELETAR USUARIO -- ");
					usuDao.deletar();
					break;
				case 4:
					
					System.out.println(" -- BUSCAR USUARIO -- ");
					usuDao.buscar();
					usuarioDAO usuDAO = new usuarioDAO();
					List<usuario> listaResultado = usuDAO.buscar();
					for(usuario u: listaResultado){
						System.out.println("Id:"+u.getId()+"\n Nome:"+u.getNome()+"\n Login:"+u.getLogin()+"\n Senha:"+u.getSenha()+"\n\n");
					}	
					break;
				case 5:
					usuDao.deletarTudo();
					break;
				
				case 0:
					System.out.println("- Saindo do programa -");
					System.exit(1);
					break;
				default:
					
					break;
			}
		} while (escolha != 0);
		
		
		teclado.close();
	} // Final funcao main

} // Final da classe

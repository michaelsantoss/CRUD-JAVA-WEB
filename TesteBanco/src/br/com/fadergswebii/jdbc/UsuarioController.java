package br.com.fadergswebii.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fadergswebii.objetos.usuario;
import br.com.fadergswebii.objetos.usuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Teste doGet");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Instanciar
		usuario usuario = new usuario();
		usuarioDAO banco = new usuarioDAO();

		doGet(request, response);
		System.out.println("Teste doPost");
		
		// Recebendo do post
		String name = request.getParameter("txtname");
		String login = request.getParameter("txtlogin");
		String password = request.getParameter("txtsenha");
		String id = request.getParameter("idUsu");
		
		// Salvando no objeto usuario
		usuario.setNome(name);
		usuario.setSenha(password);
		usuario.setLogin(login);
		if(id==null){
			banco.editar(usuario);
		}else{
			
			// Salvando no banco
			banco.cadastrar(usuario);
			
		}
		
	
	}

}

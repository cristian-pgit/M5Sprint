package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Usuario;

import java.io.IOException;
import java.util.List;

import implementacion.UsuarioDaoImpl;
import interfaces.UsuarioDAO;

/**
 * Servlet implementation class PCrearUsuario
 */
public class PCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PCrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> users = mostrarUsuarios();
		request.setAttribute("users", users);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/crearusuario.jsp");
		rd.forward(request, response);
	}
	
	private List<Usuario> mostrarUsuarios() {
		UsuarioDAO cdao = new UsuarioDaoImpl();
		List<Usuario> users = cdao.getAllUsuario();
		
		return users;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

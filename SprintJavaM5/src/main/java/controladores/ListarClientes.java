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
import java.util.ArrayList;
import java.util.List;

import implementacion.UsuarioDaoImpl;
import interfaces.ClienteDAO;
import interfaces.UsuarioDAO;

/**
 * Servlet implementation class ListarClientes
 */
public class ListarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarClientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Cliente> clients = mostrarClientes();
		request.setAttribute("clientes", clients);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listarClientes.jsp");
		rd.forward(request, response);
	}

	private List<Cliente> mostrarClientes() {
		ClienteDAO cdao = new UsuarioDaoImpl();
		List<Cliente> clients = cdao.getAllClientes();

		return clients;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

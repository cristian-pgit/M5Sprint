package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Administrativo;
import model.Cliente;

import java.io.IOException;
import java.util.List;

import implementacion.UsuarioDaoImpl;
import interfaces.AdministrativoDAO;
import interfaces.ClienteDAO;


public class ListarAdministrativos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListarAdministrativos() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Administrativo> adms = mostrarAdministrativos();
		request.setAttribute("adms", adms);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listarAdministrativos.jsp");
		rd.forward(request, response);
	}

	private List<Administrativo> mostrarAdministrativos() {
		AdministrativoDAO cdao = new UsuarioDaoImpl();
		List<Administrativo> adms = cdao.getAllAdministrativos();

		return adms;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

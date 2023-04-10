package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Profesional;

import java.io.IOException;
import java.util.List;

import implementacion.UsuarioDaoImpl;
import interfaces.ProfesionalDAO;


public class PUddProfesionales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PUddProfesionales() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Profesional> pros = mostrarProfesionales();
		request.setAttribute("pros", pros);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarProfesional.jsp");
		rd.forward(request, response);
	}

	private List<Profesional> mostrarProfesionales() {
		ProfesionalDAO pdao = new UsuarioDaoImpl();
		List<Profesional> pros = pdao.getAllProfesionales();

		return pros;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

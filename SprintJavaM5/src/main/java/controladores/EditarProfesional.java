package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Profesional;
import model.Usuario;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import implementacion.UsuarioDaoImpl;
import interfaces.ProfesionalDAO;
import interfaces.UsuarioDAO;


public class EditarProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditarProfesional() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = setUsuario(request);
		Profesional pro = setProfesional(request);
		String idUser = request.getParameter("idUser");
		int idUsuario = Integer.parseInt(idUser);
		try {
			editarUsuario(user, idUsuario);
			editarProfesional(pro, idUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("editarProfesional.jsp");
	}
	private Profesional setProfesional(HttpServletRequest request) {
		Profesional pro = null;
		String titulo = request.getParameter("titulo");
		String fechaIng = request.getParameter("fechaIng");
		if (titulo == null || fechaIng == null ) {
			System.out.println("formulario con campos vacio");
		} else {
			pro = new Profesional();
			try {
				pro.setTitulo(titulo);
				pro.setFechaIng(getDate(fechaIng));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pro;
	}


	private void editarUsuario(Usuario user, int idUsuario) {
		UsuarioDAO udao = new UsuarioDaoImpl();
		udao.updateUsuario(user, idUsuario);	
	}
	
	private void editarProfesional(Profesional pro, int idUsuario) {
		ProfesionalDAO pdao = new UsuarioDaoImpl();
		pdao.updateProfesional(pro, idUsuario);	
	}
	
	private Usuario setUsuario(HttpServletRequest request) {
		Usuario user = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String fechaNac = request.getParameter("fechaNac");
		String run = request.getParameter("run");
		if (userName == null || password == null || fechaNac == null || run == null) {
			System.out.println("formulario con campos vacio");
		} else {
			user = new Usuario();
			try {
				user.setUserName(userName);
				user.setPassword(password);
				user.setfNacimiento(getDate(fechaNac));
				user.setRun(Integer.parseInt(run));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
	
	private Date getDate(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Administrativo;
import model.Usuario;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import implementacion.UsuarioDaoImpl;
import interfaces.AdministrativoDAO;
import interfaces.UsuarioDAO;

/**
 * Servlet implementation class EditarAdministrativo
 */
public class EditarAdministrativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAdministrativo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = setUsuario(request);
		Administrativo adm = setAdministrativo(request);
		String idUser = request.getParameter("idUser");
		int idUsuario = Integer.parseInt(idUser);
		try {
			editarUsuario(user, idUsuario);
			editarAdministrativo(adm, idUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("editarProfesional.jsp");
	}
	private Administrativo setAdministrativo(HttpServletRequest request) {
		Administrativo adm = null;
		String area = request.getParameter("area");
		String exPre = request.getParameter("exppre");
		if (area == null || exPre == null ) {
			System.out.println("formulario con campos vacio");
		} else {
			adm = new Administrativo();
			try {
				adm.setArea(area);
				adm.setExpPre(Integer.parseInt(exPre));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return adm;
	}


	private void editarUsuario(Usuario user, int idUsuario) {
		UsuarioDAO udao = new UsuarioDaoImpl();
		udao.updateUsuario(user, idUsuario);	
	}
	
	private void editarAdministrativo(Administrativo adm, int idUsuario) {
		AdministrativoDAO adao = new UsuarioDaoImpl();
		adao.updateAdministrativo(adm, idUsuario);	
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

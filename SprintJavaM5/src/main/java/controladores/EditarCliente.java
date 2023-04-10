package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Usuario;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import implementacion.UsuarioDaoImpl;
import interfaces.ClienteDAO;
import interfaces.UsuarioDAO;

/**
 * Servlet implementation class EditarCliente
 */
public class EditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = setUsuario(request);
		Cliente cli = setCliente(request);
		String idUser = request.getParameter("idUser");
		int idUsuario = Integer.parseInt(idUser);
		try {
			editarUsuario(user, idUsuario);
			editarCliente(cli, idUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("editarCliente.jsp");
	}
	
	private Cliente setCliente(HttpServletRequest request) {
		Cliente cli = null;
		String rut_cliente = request.getParameter("rutCliente");
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String fono = request.getParameter("telefono");
		String afp = request.getParameter("afp");
		String sds = request.getParameter("publicPrivado");
		String dir = request.getParameter("direccion");
		String com = request.getParameter("comuna");
		String edad = request.getParameter("edad");
		
		if (rut_cliente == null || nombres == null || apellidos == null || fono == null ||
				afp == null || sds == null || dir == null || com == null|| edad ==null) {
			System.out.println("formulario con campos vacio");
		} else {
			cli = new Cliente();
			try {
				cli.setRutCliente(Integer.parseInt(rut_cliente));
				cli.setNombres(nombres);
				cli.setApellidos(apellidos);
				cli.setFono(Integer.parseInt(fono));
				cli.setAfp(afp);
				cli.setSds(Integer.parseInt(sds));
				cli.setDireccion(dir);
				cli.setComuna(com);
				cli.setEdad(Integer.parseInt(edad));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cli;
	}


	private void editarUsuario(Usuario user, int idUsuario) {
		UsuarioDAO udao = new UsuarioDaoImpl();
		udao.updateUsuario(user, idUsuario);	
	}
	
	private void editarCliente(Cliente cli, int idUsuario) {
		ClienteDAO cdao = new UsuarioDaoImpl();
		cdao.updateCliente(cli, idUsuario);	
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

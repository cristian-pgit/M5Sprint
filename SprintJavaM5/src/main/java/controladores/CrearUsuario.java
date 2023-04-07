package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Administrativo;
import model.Capacitacion;
import model.Cliente;
import model.Profesional;
import model.Usuario;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import implementacion.CapacitacionDaoImpl;
import implementacion.UsuarioDaoImpl;
import interfaces.AdministrativoDAO;
import interfaces.CapacitacionDAO;
import interfaces.ClienteDAO;
import interfaces.ProfesionalDAO;
import interfaces.UsuarioDAO;


public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String perfil = request.getParameter("tipo");
		if(perfil.matches("cli")) {
			Usuario user = setUsuario(request);
			Cliente cli = setCliente(request);
			try {
				agregarUsuario(user);
				agregarCliente(cli);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("crearusuario.jsp");
		}
		if(perfil.matches("pro")) {
			Usuario user = setUsuario(request);
			Profesional pro = setProfesional(request);
			try {
				agregarUsuario(user);
				agregarProfesional(pro);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("crearusuario.jsp");
		}
		if(perfil.matches("adm")) {
			Usuario user = setUsuario(request);
			Administrativo adm = setAdministrativo(request);
			try {
				agregarUsuario(user);
				agregarAdministrativo(adm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("crearusuario.jsp");
		}
	}

	private Administrativo setAdministrativo(HttpServletRequest request) {
		Administrativo adm = null;
		String idUser = request.getParameter("idUser");
		String id_administrativo = idUser;
		String area = request.getParameter("area");
		String exPre = request.getParameter("exppre");
		if (id_administrativo == null || area == null || exPre == null ) {
			System.out.println("formulario con campos vacio");
		} else {
			adm = new Administrativo();
			try {
				adm.setIdAdm(Integer.parseInt(id_administrativo));
				adm.setArea(area);
				adm.setExpPre(Integer.parseInt(exPre));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return adm;
	}

	private Profesional setProfesional(HttpServletRequest request) {
		Profesional pro = null;
		String idUser = request.getParameter("idUser");
		String id_profesional = idUser;
		String titulo = request.getParameter("titulo");
		String fechaIng = request.getParameter("fechaIng");
		if (id_profesional == null || titulo == null || fechaIng == null ) {
			System.out.println("formulario con campos vacio");
		} else {
			pro = new Profesional();
			try {
				pro.setId_profesional(Integer.parseInt(id_profesional));
				pro.setTitulo(titulo);
				pro.setFechaIng(getDate(fechaIng));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pro;
	}

	private Cliente setCliente(HttpServletRequest request) {
		Cliente cli = null;
		String idUser = request.getParameter("idUser");
		String id_cliente = idUser;
		String rut_cliente = request.getParameter("rutCliente");
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String fono = request.getParameter("telefono");
		String afp = request.getParameter("afp");
		String sds = request.getParameter("publicPrivado");
		String dir = request.getParameter("direccion");
		String com = request.getParameter("comuna");
		String edad = request.getParameter("edad");
		if (id_cliente == null || rut_cliente == null || nombres == null || apellidos == null || fono == null ||
				afp == null || sds == null || dir == null || com == null|| edad ==null) {
			System.out.println("formulario con campos vacio");
		} else {
			cli = new Cliente();
			try {
				cli.setI_dUsuario(Integer.parseInt(id_cliente));
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


	private void agregarUsuario(Usuario user) {
		UsuarioDAO udao = new UsuarioDaoImpl();
		udao.insertUsuario(user);	
	}
	
	private void agregarCliente(Cliente cli) {
		ClienteDAO cdao = new UsuarioDaoImpl();
		cdao.crearCliente(cli);	
	}
	
	private void agregarProfesional(Profesional pro) {
		ProfesionalDAO pdao = new UsuarioDaoImpl();
		pdao.crearProfesional(pro);	
	}
	
	private void agregarAdministrativo(Administrativo adm) {
		AdministrativoDAO adao = new UsuarioDaoImpl();
		adao.crearAdministrativo(adm);
	}
	
	private Usuario setUsuario(HttpServletRequest request) {
		Usuario user = null;
		String idUser = request.getParameter("idUser");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String fechaNac = request.getParameter("fechaNac");
		String run = request.getParameter("run");
		String perfilc = request.getParameter("tipo");
		if (idUser == null || userName == null || password == null || fechaNac == null || run == null) {
			System.out.println("formulario con campos vacio");
		} else {
			user = new Usuario();
			try {
				user.setIdUsuario(Integer.parseInt(idUser));
				user.setUserName(userName);
				user.setPassword(password);
				user.setfNacimiento(getDate(fechaNac));
				user.setRun(Integer.parseInt(run));
				user.setPerfil(perfilc);
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

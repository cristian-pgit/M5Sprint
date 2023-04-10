package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.SingletonImnot;
import interfaces.AdministrativoDAO;
import interfaces.ClienteDAO;
import interfaces.ProfesionalDAO;
import interfaces.UsuarioDAO;
import model.Administrativo;
import model.Cliente;
import model.Profesional;
import model.Usuario;

public class UsuarioDaoImpl implements UsuarioDAO, ClienteDAO, ProfesionalDAO, AdministrativoDAO {

	private Connection conn;
	private Statement stm;
	private ResultSet rs;
	private PreparedStatement st;

	@Override
	public Usuario getUsuarioByNameandPass(String userName, String password) {
		final String sql = "SELECT * FROM usuario WHERE userName=? AND password=?";
		initConnection();
		Usuario user = null;
		try {

			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			rs = st.executeQuery();

			if (rs.next()) {
	            user = new Usuario();
	            user.setUserName(rs.getString(2));
	            user.setPassword(rs.getString(3));
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Usuario> getAllUsuario() {
		String sql = "SELECT * FROM usuario;";
		initConnection();
		List<Usuario> usuarios = null;
		try {
			conn = SingletonImnot.getConnection();
			stm = conn.createStatement();
			stm.executeQuery(sql);
			rs = stm.getResultSet();

			usuarios = new ArrayList<Usuario>();
			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setIdUsuario(rs.getInt(1));
				usu.setUserName(rs.getString(2));
				usu.setfNacimiento(rs.getDate(4));
				usu.setRun(rs.getInt(5));
				usu.setPerfil(rs.getString(6));

				usuarios.add(usu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;

	}

	@Override
	public int deleteUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateUsuario(Usuario usuario, int idUsuario) {
		String sqlu = "UPDATE usuario SET userName=?, password=?, fNacimiento=?, run=? WHERE idUsuario=?";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqlu);
			st.setString(1, usuario.getUserName());
			st.setString(2, usuario.getPassword());
			st.setDate(3, new java.sql.Date(usuario.getfNacimiento().getTime()));
			st.setInt(4, usuario.getRun());
			st.setInt(5, idUsuario);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (idUsuario, userName, password, fNacimiento, run, perfil) VALUES (?, ?, ?, ?, ?, ?)";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, usuario.getIdUsuario());
			st.setString(2, usuario.getUserName());
			st.setString(3, usuario.getPassword());
			st.setDate(4, new java.sql.Date(usuario.getfNacimiento().getTime()));
			st.setInt(5, usuario.getRun());
			st.setString(6, usuario.getPerfil());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void initConnection() {
		conn = null;
		stm = null;
		rs = null;
		st = null;

	}

	@Override
	public Administrativo getAdministrativoByNameandPass(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrativo> getAllAdministrativos() {
		String sql = "SELECT u.idUsuario, u.userName, u.fNacimiento, u.run, a.area, a.experiencia_previa  FROM usuario u JOIN administrativo a ON u.idUsuario = a.id_administrativo;";
		initConnection();
		List<Administrativo> admins = null;
		try {
			conn = SingletonImnot.getConnection();
			stm = conn.createStatement();
			stm.executeQuery(sql);
			rs = stm.getResultSet();

			admins = new ArrayList<Administrativo>();
			while (rs.next()) {
				Administrativo adm = new Administrativo();
				adm.setIdUsuario(rs.getInt(1));
				adm.setUserName(rs.getString(2));
				adm.setfNacimiento(rs.getDate(3));
				adm.setRun(rs.getInt(4));
				adm.setArea(rs.getString(5));
				adm.setExpPre(rs.getInt(6));
				admins.add(adm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admins;
	}

	@Override
	public int deleteAdministrativo(Integer idAdministrativo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAdministrativo(Administrativo administrativo, int idUsuario) {
		String sqla = "UPDATE administrativo SET area=?, experiencia_previa=? WHERE id_administrativo=?";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqla);
			st.setString(1, administrativo.getArea());
			st.setInt(2, administrativo.getExpPre());
			st.setInt(3, idUsuario);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void crearAdministrativo(Administrativo administrativo) {
		String sqla = "INSERT INTO administrativo (id_administrativo, area, experiencia_previa) VALUES (?, ?, ?)";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqla);
			st.setInt(1, administrativo.getIdAdm());
			st.setString(2, administrativo.getArea());
			st.setInt(3, administrativo.getExpPre());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Profesional getProfesionalByNameandPass(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesional> getAllProfesionales() {
		String sql = "SELECT u.idUsuario, u.userName, u.fNacimiento, u.run, p.titulo_profesional, p.fechaIngreso  FROM usuario u JOIN profesional p ON u.idUsuario = p.id_profesional;";
		initConnection();
		List<Profesional> pros = null;
		try {
			conn = SingletonImnot.getConnection();
			stm = conn.createStatement();
			stm.executeQuery(sql);
			rs = stm.getResultSet();

			pros = new ArrayList<Profesional>();
			while (rs.next()) {
				Profesional pro = new Profesional();
				pro.setIdUsuario(rs.getInt(1));
				pro.setUserName(rs.getString(2));
				pro.setfNacimiento(rs.getDate(3));
				pro.setRun(rs.getInt(4));
				pro.setTitulo(rs.getString(5));
				pro.setFechaIng(rs.getDate(6));
				pros.add(pro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pros;
	}

	@Override
	public int deleteProfesional(Integer idProfesional) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProfesional(Profesional profesional, int idUsuario) {
		String sqlp = "UPDATE profesional SET titulo_profesional=?, fechaIngreso=? WHERE id_profesional=?";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqlp);
			st.setString(1, profesional.getTitulo());
			st.setDate(2, new java.sql.Date(profesional.getFechaIng().getTime()));
			st.setInt(3, idUsuario);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void crearProfesional(Profesional profesional) {
		String sqlp = "INSERT INTO profesional (id_profesional, titulo_profesional, fechaIngreso) VALUES (?, ?, ?)";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqlp);
			st.setInt(1, profesional.getId_profesional());
			st.setString(2, profesional.getTitulo());
			st.setDate(3, new java.sql.Date(profesional.getFechaIng().getTime()));
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente getClienteByNameandPass(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getAllClientes() {
		String sql = "SELECT u.idUsuario, u.userName, u.fNacimiento, u.run, c.RutCliente, c.Nombres, c.Apellidos, c.telefono, c.Afp, c.SistemaDeSAlud, c.Direccion, c.Comuna, c.Edad  FROM usuario u JOIN cliente c ON u.idUsuario = c.id_Usuario;";
		initConnection();
		List<Cliente> clientes = null;
		try {
			conn = SingletonImnot.getConnection();
			stm = conn.createStatement();
			stm.executeQuery(sql);
			rs = stm.getResultSet();

			clientes = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setIdUsuario(rs.getInt(1));
				cli.setUserName(rs.getString(2));
				cli.setfNacimiento(rs.getDate(3));
				cli.setRun(rs.getInt(4));
				cli.setRutCliente(rs.getInt(5));
				cli.setNombres(rs.getString(6));
				cli.setApellidos(rs.getString(7));
				cli.setFono(rs.getInt(8));
				cli.setAfp(rs.getString(9));
				cli.setSds(rs.getInt(10));
				cli.setDireccion(rs.getString(11));
				cli.setComuna(rs.getString(12));
				cli.setEdad(rs.getInt(13));
				clientes.add(cli);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	public int deleteCliente(Integer idUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCliente(Cliente cliente, int idUsuario) {
		String sqlc = "UPDATE cliente SET RutCliente=?, Nombres=?, Apellidos=?, telefono=?, Afp=?, SistemaDeSalud=?, Direccion=?, Comuna=?, Edad=? WHERE id_Usuario=?";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqlc);
			st.setInt(1, cliente.getRutCliente());
			st.setString(2, cliente.getNombres());
			st.setString(3, cliente.getApellidos());
			st.setInt(4, cliente.getFono());
			st.setString(5, cliente.getAfp());
			st.setInt(6, cliente.getSds());
			st.setString(7, cliente.getDireccion());
			st.setString(8, cliente.getComuna());
			st.setInt(9, cliente.getEdad());
			st.setInt(10, idUsuario);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void crearCliente(Cliente cliente) {
		String sqlc = "INSERT INTO cliente (id_usuario, RutCliente, Nombres, Apellidos, telefono, Afp, SistemaDeSalud, Direccion, Comuna, Edad)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		initConnection();
		try {
			conn = SingletonImnot.getConnection();
			st = conn.prepareStatement(sqlc);
			st.setInt(1, cliente.getId_Usuario());
			st.setInt(2, cliente.getRutCliente());
			st.setString(3, cliente.getNombres());
			st.setString(4, cliente.getApellidos());
			st.setInt(5, cliente.getFono());
			st.setString(6, cliente.getAfp());
			st.setInt(7, cliente.getSds());
			st.setString(8, cliente.getDireccion());
			st.setString(9, cliente.getComuna());
			st.setInt(10, cliente.getEdad());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

package interfaces;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {

	public Usuario getUsuarioByNameandPass(String userName, String password);
	public List<Usuario> getAllUsuario();
	public int deleteUsuario(Integer idUsuario);
	public void updateUsuario(Usuario usuario, int idUsuario);
	public void insertUsuario(Usuario usuario);
}

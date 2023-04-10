package interfaces;

import java.util.List;

import model.Cliente;

public interface ClienteDAO {
	
	public Cliente getClienteByNameandPass(String userName, String password);
	public List<Cliente> getAllClientes();
	public int deleteCliente(Integer idUsuario);
	public void crearCliente(Cliente cliente);
	void updateCliente(Cliente cliente, int idUsuario);

}

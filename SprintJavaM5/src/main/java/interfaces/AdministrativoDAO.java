package interfaces;

import java.util.List;

import model.Administrativo;

public interface AdministrativoDAO {
	
	public Administrativo getAdministrativoByNameandPass(String userName, String password);
	public List<Administrativo> getAllAdministrativos();
	public int deleteAdministrativo(Integer idAdministrativo);
	public int updateAdministrativo(Administrativo administrativo);
	public void crearAdministrativo(Administrativo administrativo);

}

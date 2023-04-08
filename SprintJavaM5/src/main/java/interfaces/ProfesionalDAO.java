package interfaces;

import java.util.List;

import model.Profesional;

public interface ProfesionalDAO {
	
	public Profesional getProfesionalByNameandPass(String userName, String password);
	public List<Profesional> getAllProfesionales();
	public int deleteProfesional(Integer idProfesional);
	public int updateProfesional(Profesional profesional);
	public void crearProfesional(Profesional profesional);

}

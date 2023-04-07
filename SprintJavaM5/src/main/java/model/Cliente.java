package model;

public class Cliente extends Usuario {
	
	private int id_Usuario;
	private int rutCliente;
	private String nombres;
	private String apellidos;
	private int fono;
	private String afp;
	private int sds;
	private String direccion;
	private String comuna;
	private int edad;
	
	public Cliente() {}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setI_dUsuario(int idUsuario) {
		this.id_Usuario = idUsuario;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getFono() {
		return fono;
	}

	public void setFono(int fono) {
		this.fono = fono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public int getSds() {
		return sds;
	}

	public void setSds(int sds) {
		this.sds = sds;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	};
	
	

}

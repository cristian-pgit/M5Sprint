package model;

import java.util.Date;

public class Profesional extends Usuario {
	
	private int id_profesional;
	private String titulo;
	private Date fechaIng;
	
	public Profesional() {}

	public int getId_profesional() {
		return id_profesional;
	}

	public void setId_profesional(int id_profesional) {
		this.id_profesional = id_profesional;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(Date fechaIng) {
		this.fechaIng = fechaIng;
	};
	
	
	

}

package model;

public class Administrativo extends Usuario{

	private int idAdm;
	private String area;
	private int expPre;
	
	public Administrativo () {}

	public int getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getExpPre() {
		return expPre;
	}

	public void setExpPre(int expPre) {
		this.expPre = expPre;
	};
	
	
	
}

package es.ucm.fdi.iw.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User{
	private String dni;
	private String workplace;
	private String job;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}


}

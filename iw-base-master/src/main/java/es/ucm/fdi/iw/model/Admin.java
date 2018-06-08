package es.ucm.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
	
	@NamedQuery(name = "allAdmins", query = "select a from Admin a")
})

@Entity
public class Admin extends User{
	private String dni;
	private String workplace;
	private String job;
	private byte enabled;
	
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
	
	public byte getEnabled() {
		return enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

}

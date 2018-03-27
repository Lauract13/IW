package es.ucm.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sports {
	
	@Id
	@GeneratedValue
	private long id;
	private String sport;
	
	public Sports() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
	

}

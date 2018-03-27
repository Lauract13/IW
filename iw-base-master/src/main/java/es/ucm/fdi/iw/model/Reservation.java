package es.ucm.fdi.iw.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Reservation {
	
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	
	@OneToMany
	private Court court;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

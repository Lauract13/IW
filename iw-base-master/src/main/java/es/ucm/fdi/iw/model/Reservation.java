package es.ucm.fdi.iw.model;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


public class Reservation {
	
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	
	@OneToMany
	private Court court;
	
	@OneToOne
	private User user;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public User getIdUser() {
		return user;
	}
	public void setIdUser(User idU) {
		this.user = idU;
	}
}

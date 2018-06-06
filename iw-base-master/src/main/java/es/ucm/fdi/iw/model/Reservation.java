package es.ucm.fdi.iw.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	
	@OneToOne
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

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

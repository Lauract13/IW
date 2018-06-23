package es.ucm.fdi.iw.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name = "findUserBooking", query = "select r from Reservation r where r.user = :n"),
	@NamedQuery(name = "findAllBookings", query = "select r from Reservation r"),
	@NamedQuery(name = "booking", query = "select r from Reservation r where r.isWeekend = 0"),
	@NamedQuery(name = "freeHours", query = "select r from Reservation r where r.date = :d and r.court = :c"),
	@NamedQuery(name = "bookingCourt", query = "select r from Reservation r where r.date = :d and r.court = :c"),
	@NamedQuery(name = "reservationsPlayer", query = "select r from Reservation r where r.isWeekend = 0 and r.user = :n")
})

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private boolean isWeekend;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Court court;
	
	@ElementCollection
	@CollectionTable(name ="horas")
	private List<String> horas = new ArrayList<>();
	
	public List<String> getHoras() {
		return horas;
	}

	public void setHoras(List<String> horas) {
		this.horas = horas;
	}

	@OneToOne(cascade = CascadeType.ALL)
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

	public boolean isIsWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
}

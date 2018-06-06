package es.ucm.fdi.iw.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ReservaHoras {
	
	@Id
	private long id;
	private long idReserva;
	private String hora;
	   
	
	  
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}
	public long getIdReserva() {
		return idReserva;
	}
	
	public void setHora(String hora) {
		this.hora =hora;
	}
	public String getHora() {
		return hora;
	}
	
	
	}

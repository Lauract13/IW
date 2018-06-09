package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.util.List;

public class TReservation {
	private long id;
	private String nameCourt;
	private String date;
	private List<THour> horas;
	private boolean isWeekend;
	
	public TReservation() {
		id = 0;
		nameCourt = "";
		date = "";
		horas = new ArrayList<THour>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameCourt() {
		return nameCourt;
	}
	public void setNameCourt(String nameCourt) {
		this.nameCourt = nameCourt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<THour> getHoras() {
		return horas;
	}
	public void setHoras(List<THour> horas) {
		this.horas = horas;
	}

	public boolean isIsWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}	
}

package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.util.List;

public class TReservation {
	private long id;
	private String nameCourt;
	private String date;
	private List<String> horas;
	
	public TReservation() {
		id = 0;
		nameCourt = "";
		date = "";
		horas = new ArrayList<String>();
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
	public List<String> getHoras() {
		return horas;
	}
	public void setHoras(List<String> horas) {
		this.horas = horas;
	}	
}

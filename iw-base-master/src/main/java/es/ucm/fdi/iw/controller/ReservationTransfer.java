package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.util.List;

public class ReservationTransfer {
	private long id;
	private String nameCourt;
	private String date;
	private List<HourTransfer> horas;
	private boolean isWeekend;
	
	public ReservationTransfer() {
		id = 0;
		nameCourt = "";
		date = "";
		horas = new ArrayList<HourTransfer>();
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
	public List<HourTransfer> getHoras() {
		return horas;
	}
	public void setHoras(List<HourTransfer> horas) {
		this.horas = horas;
	}

	public boolean isIsWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}	
}

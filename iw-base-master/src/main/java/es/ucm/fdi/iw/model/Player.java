package es.ucm.fdi.iw.model;

import javax.persistence.Entity;

@Entity
public class Player extends User {
	private String team;

	public Player() {}
	
	public Player(boolean c, String t) {
		this.team = t;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}

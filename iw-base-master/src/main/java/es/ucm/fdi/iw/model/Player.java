package es.ucm.fdi.iw.model;

import javax.persistence.Entity;

@Entity
public class Player extends User {
	private boolean isCaptain;
	private String team;

	public Player() {}
	
	public Player(boolean c, String t) {
		this.isCaptain = c;
		this.team = t;
	}

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}

package es.ucm.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "findPlayerTeam", query = "select p from Player p where p.team =:t")
})

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

package com.cjuegos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sesionplayer")
public class SesionPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "sesion_id", nullable = true)
	private Sesion sesionId;
	
	@ManyToOne
	@JoinColumn(name = "player_id", nullable = true)
	private Player playerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sesion getSesionId() {
		return sesionId;
	}

	public void setSesionId(Sesion sesionId) {
		this.sesionId = sesionId;
	}

	public Player getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Player playerId) {
		this.playerId = playerId;
	}
	
	
}

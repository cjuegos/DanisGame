package com.cjuegos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sesionnormal")
public class SesionNormalQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "sesion_id", nullable = true)
	private Sesion sesionId;
	
	@ManyToOne
	@JoinColumn(name = "normalquestion_id", nullable = true)
	private NormalQuestion normalquestionId;

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

	public NormalQuestion getNormalquestionId() {
		return normalquestionId;
	}

	public void setNormalquestionId(NormalQuestion normalquestionId) {
		this.normalquestionId = normalquestionId;
	}
}

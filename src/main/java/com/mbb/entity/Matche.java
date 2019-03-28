package com.mbb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
@Entity
public class Matche { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idmatche;
	
	
	@ManyToOne
	@JoinColumn(name = "equipe1")
	private Equipe equipe1;
	
	@ManyToOne
	@JoinColumn(name = "equipe2")
	private Equipe equipe2;
	
	@ManyToOne
	@JoinColumn(name = "idchampionnat")
	private Championnat championnat;
	
	
	private int butequipe1;
	private int butequipe2;
	
	private String etat = "avenir";
	
	
	
	public Matche(Equipe equipe1, Equipe equipe2) {
		super();
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}
	

}

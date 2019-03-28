package com.mbb.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @NoArgsConstructor
@Entity
public class Equipe {
	@Id
	private String nom;
	private String Logo;
	
	@ManyToOne
	@JoinColumn(name = "nomchampionnat")
	private Championnat championnat;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipe1")
	private List<Matche> matches;
	
	private int buttotale;
	private int point;
	
}

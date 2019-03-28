package com.mbb.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NamedQueries({
@NamedQuery(name="Championnat.ChampionnatParNom",query="SELECT c FROM Championnat c WHERE c.nomchampionnat= :nomchampionnat"
)	
})
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Championnat {
	@Id
	private String nomchampionnat;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "championnat")
	private List<Equipe> equipes;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "championnat")
	private List<Matche> matches;

	



	public Championnat(String nomchampionnat, List<Equipe> equipes, List<Matche> matches) {
		super();
		this.nomchampionnat = nomchampionnat;
		this.equipes = equipes;
		this.matches = matches;
	}
	

	

}

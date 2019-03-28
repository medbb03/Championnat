package com.mbb;

import java.util.ArrayList;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mbb.entity.Championnat;
import com.mbb.entity.Equipe;

import com.mbb.service.ServiceChampionnat;
import com.mbb.service.ServiceEquipe;
import com.mbb.service.ServiceMatche;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FootApplicationTests {
	@Autowired
	private ServiceChampionnat serviceChampionnat;
	@Autowired
	private ServiceEquipe serviceEquipe;
	@Autowired
	private ServiceMatche serviceMatche;

	@Test
	public void contextLoads() {
		Championnat ligue = new Championnat();
		ligue.setNomchampionnat("ligue de france");
		serviceChampionnat.creerOuchangerChampionnat(ligue);
		

		Equipe psg = new Equipe();
		psg.setNom("psg");
		psg.setChampionnat(ligue);
		Equipe om = new Equipe();
		om.setNom("om");
		om.setChampionnat(ligue);
		Equipe op = new Equipe();
		op.setNom("ol");
		op.setChampionnat(ligue);
		Equipe os = new Equipe();
		os.setNom("nante");
		os.setChampionnat(ligue);

		serviceEquipe.creerOuchangerEquipe(psg);
		serviceEquipe.creerOuchangerEquipe(om);
		serviceEquipe.creerOuchangerEquipe(os);
		serviceEquipe.creerOuchangerEquipe(op);

		ArrayList<Equipe> equipes = new ArrayList<Equipe>();
		equipes.add(psg);
		equipes.add(om);
		equipes.add(os);
		equipes.add(op);

		ligue.setEquipes(equipes);
		serviceChampionnat.lesMatches(equipes,ligue);
	
		
	      serviceMatche.scoreMatches(1L, 3, 2);
	      serviceMatche.scoreMatches(2L, 2, 2);
	      serviceMatche.scoreMatches(3L, 1, 2);
	      serviceMatche.scoreMatches(4L, 1, 1);
	      serviceMatche.scoreMatches(5L, 3, 0);
	      serviceMatche.scoreMatches(6L, 0, 2);

	}

}

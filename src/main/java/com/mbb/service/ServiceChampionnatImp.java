package com.mbb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbb.entity.Championnat;
import com.mbb.entity.Equipe;
import com.mbb.entity.Matche;
import com.mbb.reposetory.ChampionnatDao;
import com.mbb.reposetory.MatcheDao;

@Service
@Transactional
public class ServiceChampionnatImp implements ServiceChampionnat {

	@Autowired
	private ChampionnatDao championnatDao;
	@Autowired
	private MatcheDao matcheDao;

	@Override
	public void creerOuchangerChampionnat(Championnat championnat) {

		championnatDao.save(championnat);
	}
	
	
	
	
	
	

	public void lesMatches(ArrayList<Equipe> equipes ,Championnat championnat) {
     
		for (int i = 0; i < equipes.size(); i++) {
			for (int j = i + 1; j < equipes.size(); j++) {
				Matche matche = new Matche(equipes.get(i), equipes.get(j));
				matche.setChampionnat(championnat);
				matcheDao.save(matche);
			}
		}

	}


	@Override
	public Championnat getChampionnat(String nomchampionnat) {
		return championnatDao.ChampionnatParNom(nomchampionnat);
		
	}
	
	public List<Championnat> getleschampionnat() {
		return championnatDao.findAll();
		
	}

}

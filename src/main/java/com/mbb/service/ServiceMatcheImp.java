package com.mbb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbb.entity.Equipe;
import com.mbb.entity.Matche;
import com.mbb.reposetory.EquipeDao;
import com.mbb.reposetory.MatcheDao;
@Service
@Transactional
public class ServiceMatcheImp implements ServiceMatche {
	
	@Autowired
	private MatcheDao matcheDao;
	@Autowired
	private EquipeDao equipeDao;

	@Override
	public void creerOuchangerMatche(Matche matche) {
		
		matcheDao.save(matche);

	}
	
	
	
	@Override
	public void scoreMatches(Long id, int butequipe1, int butequipe2) {
		Matche matche = matcheDao.findById(id).orElse(null);
		matche.setButequipe1(butequipe1);
		matche.setButequipe2(butequipe2);
		matche.setEtat("jouer");
		matcheDao.save(matche);
		Equipe equipe1 = matche.getEquipe1();
		Equipe equipe2 = matche.getEquipe2();
		int lesbutEquipe1 = equipe1.getButtotale();
		lesbutEquipe1+=butequipe1;
		equipe1.setButtotale(lesbutEquipe1);
		int lesbutEquipe2 = equipe2.getButtotale();
		lesbutEquipe2+=butequipe2;
		equipe2.setButtotale(lesbutEquipe2);
		
		
		int lespointequipe1 = equipe1.getPoint();
		int lespointequipe2 = equipe2.getPoint();
		if (butequipe1>butequipe2) {
			lespointequipe1+=3;
			equipe1.setPoint(lespointequipe1);
		}
		if(butequipe1<butequipe2) {
			lespointequipe2+=3;
			equipe2.setPoint(lespointequipe2);
		}
		if(butequipe1==butequipe2) {
			lespointequipe2+=1;
			lespointequipe1+=1;
			equipe1.setPoint(lespointequipe1);
			equipe2.setPoint(lespointequipe2);
		}
			
		equipeDao.save(equipe1);
		equipeDao.save(equipe2);
		
	}

}

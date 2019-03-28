package com.mbb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbb.entity.Equipe;

import com.mbb.reposetory.EquipeDao;

@Service
@Transactional
public class ServiceEquipeImp implements ServiceEquipe {
	
	@Autowired
	private EquipeDao equipeDao;

	@Override
	public void creerOuchangerEquipe(Equipe equipe) {
		equipeDao.save(equipe);

	}

}

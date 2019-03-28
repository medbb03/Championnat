package com.mbb.service;

import java.util.ArrayList;
import java.util.List;

import com.mbb.entity.Championnat;
import com.mbb.entity.Equipe;

public interface ServiceChampionnat {
	public abstract void creerOuchangerChampionnat(Championnat championnat);
	void lesMatches(ArrayList<Equipe> equipes,Championnat championnat);
	Championnat getChampionnat(String id);
	public List<Championnat> getleschampionnat() ;

}

package com.mbb.service;



import com.mbb.entity.Matche;

public interface ServiceMatche {
	public abstract void creerOuchangerMatche(Matche matche);
	public void scoreMatches(Long id , int butequipe1, int butequipe2);

}

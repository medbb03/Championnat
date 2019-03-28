package com.mbb.reposetory;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mbb.entity.Championnat;
@Repository
@Transactional
public class ChampionnatDaoImp implements ChampionnatDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Championnat ChampionnatParNom(String nomchampionnat) {
	
		return   entityManager.createNamedQuery("Championnat.ChampionnatParNom",Championnat.class).setParameter("nomchampionnat", nomchampionnat).getSingleResult();
	}

	@Override
	public void save(Championnat championnat) {
		if (championnat.getNomchampionnat() == null)
			entityManager.persist(championnat);
		else
			entityManager.merge(championnat);
		
	}
	
	@Override
	public List<Championnat> findAll() {
		return entityManager.createQuery("SELECT c FROM Championnat c",Championnat.class).getResultList();
	}



}

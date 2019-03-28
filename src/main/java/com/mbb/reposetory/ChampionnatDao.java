package com.mbb.reposetory;





import java.util.List;

import com.mbb.entity.Championnat;



public interface ChampionnatDao {
	Championnat ChampionnatParNom(String nomchampionnat);
    void save(Championnat championnat);
	List<Championnat> findAll();




}

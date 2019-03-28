package com.mbb.webServiceRest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbb.entity.Championnat;
import com.mbb.entity.Equipe;
import com.mbb.service.ServiceChampionnat;
import com.mbb.service.ServiceEquipe;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest/championnat", headers = "Accept=application/json")
public class ChampionnatRest {
	@Autowired
	private ServiceChampionnat servicechampionnat;
	@Autowired
	private ServiceEquipe serviceEquipe;
	
	@PostConstruct
	public void postConstruction() {
		Championnat ligueFrance = new Championnat();
		ligueFrance.setNomchampionnat("ligue france");
		servicechampionnat.creerOuchangerChampionnat(ligueFrance);
		Championnat ligueesp = new Championnat();
		ligueesp.setNomchampionnat("ligue espagne");
		servicechampionnat.creerOuchangerChampionnat(ligueesp);
		Championnat ligueit = new Championnat();
		ligueit.setNomchampionnat("ligue italie");
		servicechampionnat.creerOuchangerChampionnat(ligueit);
		
		servicechampionnat.creerOuchangerChampionnat(ligueit);
		Equipe aa = new Equipe();
		aa.setNom("paris");
		aa.setChampionnat(ligueFrance);
		aa.setLogo("C:/Users/Administrateur/Desktop/logofrance/psg.png");
		
		
		Equipe bb = new Equipe();
		bb.setNom("marseil");
		bb.setLogo("C:/Users/Administrateur/Desktop/logofrance/marseil.png");
		bb.setChampionnat(ligueFrance);
		
		
		Equipe cc = new Equipe();
		cc.setNom("lyon");
		cc.setLogo("C:/Users/Administrateur/Desktop/logofrance/psg.png");
		cc.setChampionnat(ligueFrance);
		
		
		Equipe dd = new Equipe();
		dd.setNom("rennes");
		dd.setChampionnat(ligueFrance);
		dd.setLogo("C:/Users/Administrateur/Desktop/logofrance/rennes.png");
		
		Equipe ee = new Equipe();
		ee.setNom("bordeau");
		ee.setLogo("C:/Users/Administrateur/Desktop/logofrance/bordeau.png");
		ee.setChampionnat(ligueFrance);
		
		Equipe ff = new Equipe();
		ff.setNom("amiens");
		ff.setLogo("C:/Users/Administrateur/Desktop/logofrance/amiens.png");
		ff.setChampionnat(ligueFrance);

		
		Equipe gg = new Equipe();
		gg.setNom("angers");
		gg.setLogo("C:/Users/Administrateur/Desktop/logofrance/angers.png");
		gg.setChampionnat(ligueFrance);
		
		Equipe hh = new Equipe();
		hh.setNom("caen");
		hh.setLogo("C:/Users/Administrateur/Desktop/logofrance/caen.png");
		hh.setChampionnat(ligueFrance);
		
		Equipe ii = new Equipe();
		ii.setNom("guingon");
		ii.setLogo("C:/Users/Administrateur/Desktop/logofrance/guingon.png");
		ii.setChampionnat(ligueFrance);
		
		Equipe jj = new Equipe();
		jj.setNom("lille");
		jj.setLogo("C:/Users/Administrateur/Desktop/logofrance/lille.png");
		jj.setChampionnat(ligueFrance);
		
		Equipe kk = new Equipe();
		kk.setNom("monaco");
		kk.setLogo("C:/Users/Administrateur/Desktop/logofrance/monaco.png");
		kk.setChampionnat(ligueFrance);
		
		Equipe ll = new Equipe();
		ll.setNom("montpelier");
		ll.setLogo("C:/Users/Administrateur/Desktop/logofrance/montpelier.png");
		ll.setChampionnat(ligueFrance);
		
		Equipe mm = new Equipe();
		mm.setNom("nime");
		mm.setLogo("C:/Users/Administrateur/Desktop/logofrance/nime.png");
		mm.setChampionnat(ligueFrance);
		
		Equipe nn = new Equipe();
		nn.setNom("strasbourg");
		nn.setLogo("C:/Users/Administrateur/Desktop/logofrance/strsbourg.png");
		nn.setChampionnat(ligueFrance);
		
		
		serviceEquipe.creerOuchangerEquipe(aa);
		serviceEquipe.creerOuchangerEquipe(bb);
		serviceEquipe.creerOuchangerEquipe(cc);
		serviceEquipe.creerOuchangerEquipe(dd);
		serviceEquipe.creerOuchangerEquipe(ee);
		serviceEquipe.creerOuchangerEquipe(ff);
		serviceEquipe.creerOuchangerEquipe(gg);
		serviceEquipe.creerOuchangerEquipe(hh);
		serviceEquipe.creerOuchangerEquipe(ii);
		serviceEquipe.creerOuchangerEquipe(jj);
		serviceEquipe.creerOuchangerEquipe(kk);
		serviceEquipe.creerOuchangerEquipe(ll);
		serviceEquipe.creerOuchangerEquipe(mm);
		serviceEquipe.creerOuchangerEquipe(nn);
		
		
		
		
		
		ArrayList<Equipe> equipes = new ArrayList<Equipe>();
		equipes.add(aa);
		equipes.add(bb);
		equipes.add(cc);
		equipes.add(dd);
		equipes.add(ee);
		equipes.add(ff);
		equipes.add(gg);
		equipes.add(hh);
		equipes.add(ii);
		equipes.add(jj);
		equipes.add(kk);
		equipes.add(ll);
		equipes.add(mm);
		equipes.add(nn);
		equipes.add(cc);
		equipes.add(dd);

		ligueFrance.setEquipes(equipes);
		servicechampionnat.lesMatches(equipes, ligueFrance);

	}



	@RequestMapping(value ="/{nomchampionnat}", method = RequestMethod.GET)
	public void getchampionnat(@PathVariable("nomchampionnat") String nomchampionnat ) {
		servicechampionnat.getChampionnat(nomchampionnat);
	}
	
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public List<Championnat> getToutLeschampionnat() {
		return servicechampionnat.getleschampionnat();		
	}


}

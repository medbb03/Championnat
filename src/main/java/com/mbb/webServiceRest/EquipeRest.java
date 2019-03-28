package com.mbb.webServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbb.entity.Equipe;
import com.mbb.service.ServiceEquipe;

@CrossOrigin(origins="*")
@RestController 
@RequestMapping(value="/rest/equipe" , headers="Accept=application/json")
public class EquipeRest {
	
	@Autowired
	private ServiceEquipe serviceEquipe;
	
	public void creeEquipe(Equipe equipe) {
		serviceEquipe.creerOuchangerEquipe(equipe);

	}

}

package com.mbb.webServiceRest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mbb.service.ServiceMatche;

@CrossOrigin(origins="*")
@RestController 
@RequestMapping(value="/rest/matche" , headers="Accept=application/json")
public class MatcheRest {
	@Autowired
	private ServiceMatche serviceMatche;
	
	@RequestMapping(value="" , method=RequestMethod.POST)
	public void resultatMatche(@RequestBody Long id,@RequestBody int butequipe1,@RequestBody int butequipe2) {
		serviceMatche.scoreMatches(id, butequipe1, butequipe2);
			
	}

}

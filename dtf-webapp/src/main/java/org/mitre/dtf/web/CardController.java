package org.mitre.dtf.web;

import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {

	@Autowired
	CardRepository cardRepository;
	
	@RequestMapping(value = "/card", method = RequestMethod.GET, produces = "application/json")
	public Set<Card> getAll() {
		
		return cardRepository.getAll();
	}
}

package org.mitre.dtf.web;

import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CardController {

	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/card", method = RequestMethod.GET, produces = "application/json")
	public Set<Card> getAll() {
		
		return cardService.getAllCards();
	}
	
	@RequestMapping("/ui")
	public ModelAndView ui(){
	    return new ModelAndView("ui");
	}
}

package org.mitre.dtf.web;

import java.util.List;
import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.InstanceCard;
import org.mitre.dtf.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {

	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/card", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Card> getAll() {
		
		return cardService.getAllCards();
	}
	
	@RequestMapping(value = "/card/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Card getCard(@PathVariable("id") long id) {
		return cardService.getById(id);
	}
	
	@RequestMapping(value = "/card/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Card updateCard(@RequestBody Card card) {
		return cardService.save(card);
	}
	
	@RequestMapping(value = "/card/new", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Card newCard() {
		return cardService.getNewCard();
	}
	
	@RequestMapping(value = "/card/new", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Card newCard(@RequestBody Card card) {
		return cardService.save(card);
	}
	
	@RequestMapping(value = "/instance", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<InstanceCard> saveInstance(@RequestBody List<InstanceCard> instanceCards) {
		
		cardService.saveInstance(instanceCards);
		
		return instanceCards;
	}
}

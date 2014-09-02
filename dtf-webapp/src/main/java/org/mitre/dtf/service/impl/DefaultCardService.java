/**
 * 
 */
package org.mitre.dtf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.CardNode;
import org.mitre.dtf.model.Instance;
import org.mitre.dtf.model.InstanceCard;
import org.mitre.dtf.repository.CardRepository;
import org.mitre.dtf.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wkim
 *
 */
@Service("defaultCardService")
public class DefaultCardService implements CardService {

	@Autowired
	CardRepository cardRepository;	
	
	/* (non-Javadoc)
	 * @see org.mitre.dtf.service.CardService#getAllCards()
	 */
	@Override
	public Set<Card> getAllCards() {
		return cardRepository.getAll();
	}
	
	@Override
	public Card getById(long id) {
		return cardRepository.getById(id);
	}

	//TODO some error checking. What happens if bad instance card ids are sent?
	@Override
	public Instance saveInstance(List<InstanceCard> instanceCards) {
		
		Map<Long, Card> idCardMap = new HashMap<Long, Card>(); // for lookup by card id
		
		// build up deck of the actual cards in the instance
		for (InstanceCard ic : instanceCards) {
			Card card = cardRepository.getById(ic.getId());
			idCardMap.put(ic.getId(), card);
		}
		
		// build up the card nodes and links
		for (InstanceCard ic : instanceCards) {
			Card currentCard = idCardMap.get(ic.getId());
			//TODO actually do something with this instance
			
		}
		
		return null;
	}

}

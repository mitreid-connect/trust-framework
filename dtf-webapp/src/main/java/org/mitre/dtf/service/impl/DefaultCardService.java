/**
 * 
 */
package org.mitre.dtf.service.impl;

import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.Instance;
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
	public Instance saveInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}

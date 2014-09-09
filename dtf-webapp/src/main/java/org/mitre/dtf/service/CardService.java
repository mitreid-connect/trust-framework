/**
 * 
 */
package org.mitre.dtf.service;

import java.util.List;
import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.Instance;
import org.mitre.dtf.model.InstanceCard;

/**
 * @author wkim
 *
 */
public interface CardService {

	public Set<Card> getAllCards();
	
	public Card getById(long id);
	
	public Card getNewCard();
	
	public Card save(Card card);
	
	public Instance saveInstance(List<InstanceCard>instanceCards);
}

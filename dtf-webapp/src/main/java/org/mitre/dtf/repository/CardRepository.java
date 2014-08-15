/**
 * 
 */
package org.mitre.dtf.repository;

import java.util.Set;

import org.mitre.dtf.model.Card;

/**
 * @author wkim
 *
 */
public interface CardRepository {

	public Set<Card> getAll();
	
	public Card getById(long id);
	
	public void remove(Card card);
	
	public Card save(Card card);
}

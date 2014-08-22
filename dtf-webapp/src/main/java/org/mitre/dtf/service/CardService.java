/**
 * 
 */
package org.mitre.dtf.service;

import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.Instance;

/**
 * @author wkim
 *
 */
public interface CardService {

	public Set<Card> getAllCards();
	
	public Instance saveInstance();
}

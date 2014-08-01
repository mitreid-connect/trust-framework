package org.mitre.dtf.repository;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mitre.dtf.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/application-context.xml")
public class JpaCardRepositoryTest {

	@Autowired
	JpaCardRepository cardRepository;

	@Test
	public void testInitialState() {

		Set<Card> cards = cardRepository.getAll();
		
		Set<String> cardTitles = new HashSet<String>();
		
		for (Card c : cards) {
			cardTitles.add(c.getTitle());
		}
		
		assertTrue(cardTitles.contains("goldfish"));
		assertTrue(cardTitles.contains("fish flakes"));
	}
	
	
}

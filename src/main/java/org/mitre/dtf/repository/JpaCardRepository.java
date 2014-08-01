package org.mitre.dtf.repository;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mitre.dtf.model.Card;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("jpaCardRepository")
public class JpaCardRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Set<Card> getAll() {
		
		TypedQuery<Card> query = em.createNamedQuery("Card.findAll", Card.class);

		return new LinkedHashSet<Card>(query.getResultList());
	}
}

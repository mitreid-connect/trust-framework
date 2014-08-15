package org.mitre.dtf.repository.impl;

import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mitre.dtf.model.Dependency;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository layer for translating Dependency POJOs to and from database.
 * 
 * @author wkim
 *
 */
@Repository("jpaDependencyRepository")
public class JpaDependencyRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Set<Dependency> getAll() {
		
		TypedQuery<Dependency> query = em.createNamedQuery("Dependency.findAll", Dependency.class);

		return new LinkedHashSet<Dependency>(query.getResultList());
	}
	
	@Transactional
	public Dependency getById(long id) {
		return em.find(Dependency.class, id);
	}
	
	@Transactional
	public void remove(Dependency dependency) {
		Dependency found = em.find(Dependency.class, dependency.getId());

		if (found != null) {
			em.remove(dependency);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Transactional
	public Dependency save(Dependency dependency) {
		return saveOrUpdate(dependency.getId(), em, dependency);
	}
}

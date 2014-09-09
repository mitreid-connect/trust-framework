package org.mitre.dtf.repository.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mitre.dtf.model.Tag;
import org.mitre.dtf.repository.TagRepository;
import org.mitre.util.jpa.JpaUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository layer for translating Tag POJOs to and from the database.
 * 
 * @author wkim
 *
 */
@Repository("jpaTagRepository")
public class JpaTagRepository implements TagRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Set<Tag> getAll() {
		TypedQuery<Tag> query = em.createNamedQuery("Tag.findAll", Tag.class);
		return new LinkedHashSet<Tag>(query.getResultList());
	}
	
	@Override
	@Transactional
	public Tag getById(long id) {
		return em.find(Tag.class, id);
	}
	
	@Override
	@Transactional
	public void remove(Tag tag) {
		Tag found = em.find(Tag.class, tag.getId());

		if (found != null) {
			em.remove(tag);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Tag save(Tag tag) {
		return JpaUtil.saveOrUpdate(tag.getId(), em, tag);
	}
	
}

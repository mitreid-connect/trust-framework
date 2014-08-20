/**
 * 
 */
package org.mitre.dtf.repository.impl;

import static org.mitre.util.jpa.JpaUtil.saveOrUpdate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mitre.dtf.model.Instance;
import org.mitre.dtf.repository.InstanceRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wkim
 *
 */
@Repository("jpaInstanceRepository")
public class JpaInstanceRepository implements InstanceRepository {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see org.mitre.dtf.repository.InstanceRepository#getById(long)
	 */
	@Override
	@Transactional
	public Instance getById(long id) {
		return em.find(Instance.class, id);
	}

	/* (non-Javadoc)
	 * @see org.mitre.dtf.repository.InstanceRepository#save(org.mitre.dtf.model.Instance)
	 */
	@Override
	@Transactional
	public Instance save(Instance instance) {
		return saveOrUpdate(instance.getId(), em, instance);
	}

}

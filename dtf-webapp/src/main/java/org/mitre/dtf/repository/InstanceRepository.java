/**
 * 
 */
package org.mitre.dtf.repository;

import org.mitre.dtf.model.Instance;

/**
 * @author wkim
 *
 */
public interface InstanceRepository {
	
	public Instance getById(long id);
	
	public Instance save(Instance instance);
}

/**
 * 
 */
package org.mitre.dtf.service.impl;

import java.util.Set;

import org.mitre.dtf.model.Tag;
import org.mitre.dtf.repository.TagRepository;
import org.mitre.dtf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wkim
 *
 */
@Service("defaultTagService")
public class DefaultTagService implements TagService {

	@Autowired
	TagRepository tagRepository;
	
	/* (non-Javadoc)
	 * @see org.mitre.dtf.service.TagService#getAll()
	 */
	@Override
	public Set<Tag> getAll() {
		return tagRepository.getAll();
	}

	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}

}

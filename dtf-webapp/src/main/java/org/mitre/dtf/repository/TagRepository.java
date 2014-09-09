package org.mitre.dtf.repository;

import java.util.Set;

import org.mitre.dtf.model.Tag;

public interface TagRepository {
	public Set<Tag> getAll();
	public Tag getById(long id);
	public void remove(Tag tag);
	public Tag save(Tag tag);
}

package org.mitre.dtf.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Entity
@Table(name = "Card")
@NamedQueries({
	@NamedQuery(name = "Card.findAll", query = "select c from Card c ORDER BY c.id")
})
public class Card {

	private long id; // unique identifier
	private String title; // human-readable title
	private String description; // human-readable description
	private List<Dependency> dependencies; // list of dependency slots
	private Set<Tag> providesTags; // set of tags this card provides

	/**
	 * Default empty parameter constructor.
	 */
	public Card() {
		// left blank intentionally
	}

	public Card(String title, String description) {
		this.title = title;
		this.description = description;
		
		this.dependencies = Lists.newArrayList();
		this.providesTags = Sets.newHashSet();
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	@Basic
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	@Basic
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
	@JsonManagedReference
	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Provides", 
		joinColumns = @JoinColumn(name = "cardId", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "tagId", referencedColumnName = "id"))
	public Set<Tag> getProvidesTags() {
		return providesTags;
	}

	public void setProvidesTags(Set<Tag> tags) {
		this.providesTags = tags;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dependencies == null) ? 0 : dependencies.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((providesTags == null) ? 0 : providesTags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (dependencies == null) {
			if (other.dependencies != null)
				return false;
		} else if (!dependencies.equals(other.dependencies))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (providesTags == null) {
			if (other.providesTags != null)
				return false;
		} else if (!providesTags.equals(other.providesTags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", description="
				+ description + ", dependencies=" + dependencies
				+ ", providesTags=" + providesTags + "]";
	}


}

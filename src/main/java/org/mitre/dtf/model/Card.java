package org.mitre.dtf.model;

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
import javax.persistence.Table;

import com.google.common.collect.Sets;

@Entity
@Table(name = "card")
@NamedQueries({
	@NamedQuery(name = "Card.findAll", query = "select c from Card c ORDER BY c.id")
})
public class Card {

	private long id;
	private String title;
	private String description;
	private Set<Tag> dependsTags;
	private Set<Tag> providesTags;

	/**
	 * Default empty parameter constructor.
	 */
	public Card() {
		// left blank intentionally
	}

	public Card(String title, String description) {
		this.title = title;
		this.description = description;
		
		this.dependsTags = Sets.newHashSet();
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "depends", 
			joinColumns = @JoinColumn(name = "cardId", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "tagId", referencedColumnName = "id"))
	public Set<Tag> getDependsTags() {
		return dependsTags;
	}

	public void setDependsTags(Set<Tag> tags) {
		this.dependsTags = tags;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "provides", 
		joinColumns = @JoinColumn(name = "cardId", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "tagId", referencedColumnName = "id"))
	public Set<Tag> getProvidesTags() {
		return providesTags;
	}

	public void setProvidesTags(Set<Tag> tags) {
		this.providesTags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dependsTags == null) ? 0 : dependsTags.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((providesTags == null) ? 0 : providesTags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (dependsTags == null) {
			if (other.dependsTags != null)
				return false;
		} else if (!dependsTags.equals(other.dependsTags))
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

	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", description="
				+ description + ", dependsTags=" + dependsTags
				+ ", providesTags=" + providesTags + "]";
	}

}

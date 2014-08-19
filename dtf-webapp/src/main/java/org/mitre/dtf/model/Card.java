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
@Entity
@Table(name = "Card")
@NamedQueries({
	@NamedQuery(name = "Card.findAll", query = "select c from Card c ORDER BY c.id")
})
public class Card {

	private long id; // unique identifier
	private String title; // human-readable title
	private String businessTxt;
	private String legalTxt;
	private String technicalTxt;
	private List<Dependency> dependencies; // list of dependency slots
	private Set<Tag> providesTags; // set of tags this card provides

	/**
	 * Default empty parameter constructor.
	 */
	public Card() {
		// left blank intentionally
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
	 * @return the businessTxt
	 */
	@Basic
	@Column(name = "businessTxt")
	public String getBusinessTxt() {
		return businessTxt;
	}

	/**
	 * @param businessTxt the businessTxt to set
	 */
	public void setBusinessTxt(String businessTxt) {
		this.businessTxt = businessTxt;
	}

	/**
	 * @return the legalTxt
	 */
	@Basic
	@Column(name = "legalTxt")
	public String getLegalTxt() {
		return legalTxt;
	}

	/**
	 * @param legalTxt the legalTxt to set
	 */
	public void setLegalTxt(String legalTxt) {
		this.legalTxt = legalTxt;
	}

	/**
	 * @return the technicalTxt
	 */
	@Basic
	@Column(name = "technicalTxt")
	public String getTechnicalTxt() {
		return technicalTxt;
	}

	/**
	 * @param technicalTxt the technicalTxt to set
	 */
	public void setTechnicalTxt(String technicalTxt) {
		this.technicalTxt = technicalTxt;
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
				+ ((businessTxt == null) ? 0 : businessTxt.hashCode());
		result = prime * result
				+ ((dependencies == null) ? 0 : dependencies.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((legalTxt == null) ? 0 : legalTxt.hashCode());
		result = prime * result
				+ ((providesTags == null) ? 0 : providesTags.hashCode());
		result = prime * result
				+ ((technicalTxt == null) ? 0 : technicalTxt.hashCode());
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
		if (businessTxt == null) {
			if (other.businessTxt != null)
				return false;
		} else if (!businessTxt.equals(other.businessTxt))
			return false;
		if (dependencies == null) {
			if (other.dependencies != null)
				return false;
		} else if (!dependencies.equals(other.dependencies))
			return false;
		if (id != other.id)
			return false;
		if (legalTxt == null) {
			if (other.legalTxt != null)
				return false;
		} else if (!legalTxt.equals(other.legalTxt))
			return false;
		if (providesTags == null) {
			if (other.providesTags != null)
				return false;
		} else if (!providesTags.equals(other.providesTags))
			return false;
		if (technicalTxt == null) {
			if (other.technicalTxt != null)
				return false;
		} else if (!technicalTxt.equals(other.technicalTxt))
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
		return "Card [id=" + id + ", title=" + title + ", providesTags="
				+ providesTags + "]";
	}

}

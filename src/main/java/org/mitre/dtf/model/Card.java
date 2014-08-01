package org.mitre.dtf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "card")
@NamedQueries({
	@NamedQuery(name = "Card.findAll", query = "select c from Card c ORDER BY c.id")
})
public class Card {
	
	private long id;
	private String title;
	private String description;
	
	/**
	 * Default empty constructor.
	 */
	public Card() {
		// left blank intentionally
	}
	
	public Card(String title, String description) {
		this.title = title;
		this.description = description;
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
	
	@Override
	public String toString() {
		return "Card [Title=" + title + ", Description=" + description + "]";
	}
}

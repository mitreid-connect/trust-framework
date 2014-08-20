/**
 * 
 */
package org.mitre.dtf.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class represents a card as part of a trust framework instance as part of
 * a tree-like data structure.
 * 
 * @author wkim
 *
 */
@Entity
@Table(name="CardNode")
public class CardNode {

	private long id;
	private Card card;
	private CardNode parentCardNode;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the card
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cardId", referencedColumnName = "id")
	public Card getCard() {
		return card;
	}
	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}
	/**
	 * @return the parentCardNode
	 */
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentCardNodeId", referencedColumnName = "id")
	@JsonBackReference
	public CardNode getParentCardNode() {
		return parentCardNode;
	}
	/**
	 * @param parentCardNode the parentCardNode to set
	 */
	public void setParentCardNode(CardNode parentCardNode) {
		this.parentCardNode = parentCardNode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((parentCardNode == null) ? 0 : parentCardNode.hashCode());
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
		CardNode other = (CardNode) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (id != other.id)
			return false;
		if (parentCardNode == null) {
			if (other.parentCardNode != null)
				return false;
		} else if (!parentCardNode.equals(other.parentCardNode))
			return false;
		return true;
	}
	
	
}

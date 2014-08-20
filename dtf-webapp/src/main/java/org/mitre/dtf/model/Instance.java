/**
 * 
 */
package org.mitre.dtf.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents a complete instance of a trust framework and its components.
 * 
 * @author wkim
 *
 */
@Entity
@Table(name="Instance")
public class Instance {

	private long id; // unique identifier
	private String name; // human-readable name
	
	private CardNode rootCardNode;
	private Set<CardNode> cardNodeTree;
	
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
	 * @return the name
	 */
	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rootCardNode
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rootCardNodeId", referencedColumnName = "id")
	@JsonManagedReference
	public CardNode getRootCardNode() {
		return rootCardNode;
	}
	/**
	 * @param rootCardNode the rootCardNode to set
	 */
	public void setRootCardNode(CardNode rootCardNode) {
		this.rootCardNode = rootCardNode;
	}
	/**
	 * @return the cardTree
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "InstanceCardNodes", 
	joinColumns = @JoinColumn(name = "instanceId", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "cardNodeId", referencedColumnName = "id"))
	@JsonManagedReference
	public Set<CardNode> getCardNodeTree() {
		return cardNodeTree;
	}
	/**
	 * @param cardTree the cardTree to set
	 */
	public void setCardNodeTree(Set<CardNode> cardNodeTree) {
		this.cardNodeTree = cardNodeTree;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNodeTree == null) ? 0 : cardNodeTree.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rootCardNode == null) ? 0 : rootCardNode.hashCode());
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
		Instance other = (Instance) obj;
		if (cardNodeTree == null) {
			if (other.cardNodeTree != null)
				return false;
		} else if (!cardNodeTree.equals(other.cardNodeTree))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rootCardNode == null) {
			if (other.rootCardNode != null)
				return false;
		} else if (!rootCardNode.equals(other.rootCardNode))
			return false;
		return true;
	}
}

/**
 * 
 */
package org.mitre.dtf.model;

import java.util.List;

/**
 * Container object for storing the intermediary JSON representation of instance cards.
 * @author wkim
 *
 */
public class InstanceCard {
	
	private long id; // card id
	private long parent; // id of parent card
	private List<Long> children; // list of ids of cards that fulfilled this card's dependencies
	/**
	 * @return the id
	 */
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
	 * @return the parent
	 */
	public long getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(long parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	public List<Long> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Long> children) {
		this.children = children;
	}
}

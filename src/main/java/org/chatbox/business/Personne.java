package org.chatbox.business;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Personne Bean.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
@XmlRootElement
@Entity
@Cacheable(false)
public class Personne {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	Long idPersonne;

	/** Name of the Personne. */
	String name;

	public Personne() {
		super();
	}

	public Personne(final String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return idPersonne;
	}

	public void setId(final Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
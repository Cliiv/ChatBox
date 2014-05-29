package org.chatbox.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
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

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(final Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
package org.chatbox.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.chatbox.json.JsonListMessageId;
import org.chatbox.json.JsonListPersonneId;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Chat Bean.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
@XmlRootElement
@Entity
public class Chat {
	/** Unique identifier of ChatBox. */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	Long idChat;

	/** Subject of chat. */
	String name;

	@OneToMany(targetEntity = Message.class, mappedBy = "chat")
	private List<Message> messages;

	@ManyToMany
	private List<Personne> personnes;

	public Chat() {
		super();
	}

	public Chat(Long idChat, String name, List<Message> messages,
			List<Personne> personnes) {
		super();
		this.name = name;
		this.messages = messages == null ? new ArrayList<Message>() : messages;
		this.personnes = personnes == null ? new ArrayList<Personne>()
				: personnes;
	}

	public Long getId() {
		return idChat;
	}

	public void setId(Long idChat) {
		this.idChat = idChat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonSerialize(using = JsonListMessageId.class)
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(final Message message) {
		this.messages.add(message);
	}

	@JsonSerialize(using = JsonListPersonneId.class)
	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public void addPersonne(final Personne personne) {
		this.personnes.add(personne);
	}
}
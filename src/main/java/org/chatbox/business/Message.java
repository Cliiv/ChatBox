package org.chatbox.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.chatbox.json.JsonChatId;
import org.chatbox.json.JsonPersonneId;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long idMessage;

	private String texte;

	@ManyToOne(targetEntity = Chat.class)
	private Chat chat;

	private Personne personne;

	public Message() {
		super();
	}

	public Message(Long idMessage, String texte, Chat chat, Personne personne) {
		super();
		this.idMessage = idMessage;
		this.texte = texte;
		this.chat = chat;
		chat.addMessage(this);
		this.personne = personne;
	}

	public long getId() {
		return idMessage;
	}

	public void setId(final Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@JsonSerialize(using = JsonChatId.class)
	public Chat getChat() {
		return this.chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@JsonSerialize(using = JsonPersonneId.class)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
}
package org.chatbox.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.chatbox.business.Chat;
import org.chatbox.business.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Message Bean api.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
@Controller
@RequestMapping("/message")
public class ChatMessageController {
	/** EntityManager that manage DB IO. */
	final EntityManager em = ChatController.ENTITY_MANAGER;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Message get(final @PathVariable("id") Long messageId) {
		return (Message) em.find(Message.class, messageId);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Message> getMessageSujet(
			final @RequestParam(value = "chatId", required = true) Long idChat) {
		final Chat chat = (Chat) em.find(Chat.class, idChat);
		return chat != null ? chat.getMessages() : null;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void postMessage(final @RequestBody Message message) {
		final EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			em.persist(message);
			tx.commit();
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}
}

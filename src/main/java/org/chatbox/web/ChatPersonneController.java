package org.chatbox.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.chatbox.business.Personne;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/personne")
public class ChatPersonneController {
	final EntityManager em = ChatController.ENTITY_MANAGER;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Personne get(final @PathVariable("id") Long personneId) {
		System.out.println("chat");
		return (Personne) em.find(Personne.class, personneId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void postMessage(final @RequestBody Personne personne) {
		final EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			em.persist(personne);
			tx.commit();
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}
}

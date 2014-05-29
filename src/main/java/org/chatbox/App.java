package org.chatbox;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.chatbox.business.Chat;
import org.chatbox.business.Message;
import org.chatbox.business.Personne;

/**
 * Application ChatBox
 * 
 * @version 1.0 - 2014-05-19 - Version initiale
 */
public class App {
	public static void main(final String[] args) {
		final EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("chatbox");
		final EntityManager entityManager = emf.createEntityManager();

		final EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		Personne bob = new Personne("bob");

		Chat chat = new Chat(null, "miaou", null, Arrays.asList(bob));
		Chat chat1 = new Chat(null, "miaou2", null, Arrays.asList(bob));
		Chat chat2 = new Chat(null, "miaou3", null, Arrays.asList(bob));
		
		Message m1 = new Message(null, "le premier message", chat, bob);

		entityManager.persist(bob);
		entityManager.persist(chat);
		entityManager.persist(chat1);
		entityManager.persist(chat2);
		entityManager.persist(m1);

		tx.commit();
		
		System.out.println("fin de chargement en base");
	}
}

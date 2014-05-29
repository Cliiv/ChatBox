package org.chatbox.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ChatController {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("chatbox");
	public static final EntityManager ENTITY_MANAGER = emf
			.createEntityManager();
}

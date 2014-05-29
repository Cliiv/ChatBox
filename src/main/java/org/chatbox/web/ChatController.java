package org.chatbox.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Common components of ChatBox WebApp.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
public abstract class ChatController {
	/** EntityManager singleton that handle every request. */
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("chatbox");
	public static final EntityManager ENTITY_MANAGER = emf
			.createEntityManager();
}

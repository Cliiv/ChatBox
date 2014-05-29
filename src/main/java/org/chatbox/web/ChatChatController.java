package org.chatbox.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.chatbox.business.Chat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Chat Bean api.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
@Controller
public class ChatChatController {
	/** EntityManager that manage DB IO. */
	final EntityManager em = ChatController.ENTITY_MANAGER;

	@RequestMapping("/chat")
	public ModelAndView lstChat() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsp_lstChats");
		return modelAndView;
	}

	@RequestMapping(value = "/chats", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Chat> getMessageSujet() {
		final CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<Chat> criteriaQuery = criteria.createQuery(Chat.class);
        Root<Chat> rootEntry = criteriaQuery.from(Chat.class);
        CriteriaQuery<Chat> all = criteriaQuery.select(rootEntry);
        TypedQuery<Chat> allQuery = em.createQuery(all);
        return allQuery.getResultList();
	}
}

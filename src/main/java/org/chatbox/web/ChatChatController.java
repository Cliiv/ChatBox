package org.chatbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatChatController {
	
	@RequestMapping("/chat")
	public ModelAndView lstChat(){
			System.out.println("ChatChatController");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("jsp_lstChats");
			return modelAndView;
	}
}

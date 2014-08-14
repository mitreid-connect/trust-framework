package org.mitre.dtf.web;

import java.util.Map;

import org.mitre.dtf.repository.JpaCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	JpaCardRepository repository;
	
	@RequestMapping({"/","/home"})
	public String home(Map<String, Object> model) {
		
		// TODO populate the model
		model.put("cards", repository.getAll());
		
		return "home";
	}
}

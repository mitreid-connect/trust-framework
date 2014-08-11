package org.mitre.dtf.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public String home(Map<String, Object> model) {
		
		// TODO populate the model
		
		return "home";
	}
}

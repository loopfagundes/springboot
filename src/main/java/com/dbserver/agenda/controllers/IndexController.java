package com.dbserver.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbserver.agenda.models.AgendaModel;
import com.dbserver.agenda.repositories.AgendaRepository;


@Controller
public class IndexController {
	@Autowired
	AgendaRepository agendaRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("index");
		
		Iterable<AgendaModel> agenda = agendaRepository.findAll();
		modelView.addObject("agenda", agenda);
			
		return modelView;
	}
	
	@PostMapping("/")
	public String novoContato(AgendaModel agenda) {
	    agendaRepository.save(agenda);
	    return "redirect:/";
	}
	
	
}

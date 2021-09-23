package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorServicedb;

@Controller
public class ActorController {

	@Autowired
	private ActorServicedb actordb;
	
	
	@GetMapping("/new-actor")
	public String formToSave(Model model) {
		
		model.addAttribute("newActor", new Actor());
		
		return "actor_save";
	}
	
	@PostMapping("/new-actor")
	public String save(@ModelAttribute("newActor") Actor actor) {
	
		this.actordb.create(actor);
		return "redirect:/actors";
	
	}
	
	@GetMapping("/actors")
	public String view(Model model) {
		
		model.addAttribute("actorsList", this.actordb.readAll());
		
		return "actor_view";
	}
	
	
	
	@GetMapping("/update-actor/{id}")
	public String update(@PathVariable("id") Long id, Model model ) {
		
		Actor actor = this.actordb.getActor( new Actor(id) );
	    model.addAttribute("updateActor", actor);
		
	    return "actor_update";
	}
	
	@GetMapping("/delete-actor/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.actordb.delete( new Actor(id) );
		return "redirect:/actors";
	}
	
}

package com.amanuel.dojoNinja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amanuel.dojoNinja.models.Dojo;
import com.amanuel.dojoNinja.models.Ninja;
import com.amanuel.dojoNinja.services.Services;


@Controller
public class Dojos {
	private Services services;
	
	public Dojos(Services services) {
		this.services = services;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo,BindingResult result) {
		return "index";
	}
	@PostMapping("/new")
	public String newDojo(RedirectAttributes redirectAtributes, @ModelAttribute("dojo") Dojo dojo,@RequestParam(value = "name",required = false) String name, BindingResult result) {
		services.saveDojo(dojo);
		return "redirect:/ninjas";
	}
	@RequestMapping("/ninjas")
	public String newNinjas(RedirectAttributes redirectAtributes,Model model,@ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		System.out.println("hellooo");
		model.addAttribute("dojos", services.findAll());
		return "ninjasPage";
		
	}
	@PostMapping("/ninjas/new")
	public String saveNewNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		Ninja n = services.saveNinja(ninja);
		String id = Long.toString(n.getDojo().getId());
		return "redirect:/ninjas/".concat(id);
	}
	@RequestMapping("/ninjas/{id}")
	public String ninjaShow(@PathVariable("id") Long id, Model model) {
		Dojo findDojo = services.findDojoById(id);
		model.addAttribute("dojo", findDojo.getNinjas());
		model.addAttribute("dojoLoc",findDojo);
		return "locationNinjaPage";
	}
	
}

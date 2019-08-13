package com.jd.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jd.dojosninjas.models.Dojo;
import com.jd.dojosninjas.models.Ninja;
import com.jd.dojosninjas.services.DNService;

@Controller
public class DNController {
	@Autowired
	private DNService dnService;

	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "new-dojo.jsp";
	}

	@PostMapping("/create-dojo")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "new-dojo.jsp";
		} else {
			dnService.create(dojo);
			return "redirect:/dojos/new";
		}
	}

	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dnService.allDojos());
		return "new-ninja.jsp";
	}

	@PostMapping("/create-ninja")
	public String create(@RequestParam("dojo") Long dojoid, @RequestParam("firstName") String fName,
			@RequestParam("lastName") String lName, @RequestParam("age") int age) {
		Dojo dojo = dnService.findDojoById(dojoid);
		Ninja ninja = new Ninja();
		ninja.setFirstName(fName);
		ninja.setLastName(lName);
		ninja.setAge(age);
		ninja.setDojo(dojo);
		dnService.create(ninja);
		return "redirect:/ninjas/new";
	}

	@RequestMapping("dojo/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dnService.findDojoById(id));
		model.addAttribute("ninjas", dnService.findAllNinjasByDojoId(id));
		return "show.jsp";
	}
}







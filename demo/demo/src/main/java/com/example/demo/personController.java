package com.example.demo;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;


import com.example.demo.mysql.Repo;
import com.example.demo.mysql.User;



@Controller
public class personController {
	private Repo repo;
	
	public personController(Repo repo) {
		this.repo=repo;
	}
	
	@RequestMapping({"/"})
	public String getMapping(Model model) {
		model.addAttribute("users", repo.findAll());
		return "index";
	}
	@RequestMapping({"/tests"})
	public String html(User user) {
		return "add-user";
	}
	@RequestMapping({"/adduser"})
	public String addUser(@Validated User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-user";
		}
		repo.save(user);
		return "redirect:/index";
	}
}


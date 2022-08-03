package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class personController {
	
	@RequestMapping({"/doods"})
	public String getController() {
		return "people";
	}
	@RequestMapping({"/"})
	public String testController() {
		return "men";
	}
	
}
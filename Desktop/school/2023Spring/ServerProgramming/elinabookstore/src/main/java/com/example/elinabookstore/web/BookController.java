package com.example.elinabookstore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class BookController {

	@RequestMapping("/index")
	public String bookForm(Model model) {
		return "index";
	}
	
}
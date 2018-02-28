package com.ciecc.fire.download.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueController {

	@GetMapping("vue")
	public String single() {
		return "vue/single";
	}
}

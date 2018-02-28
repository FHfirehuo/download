package com.ciecc.fire.download.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SelfController {

	@GetMapping("self/page")
	public String FileList(){
		return "self/page";
	}
}

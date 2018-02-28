package com.ciecc.fire.download.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadController {

	@PreAuthorize("true")
	@GetMapping("upload/page")
	public String FileList(){
		return "upload/page";
	}
}

package com.ciecc.fire.download.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciecc.fire.download.domain.DownLoadTask;
import com.ciecc.fire.download.service.DownloadService;
import com.ciecc.fire.download.web.WebConstant;

@Controller
public class DownloadController {
	
	@Autowired
	private DownloadService downloadService;

	//@PreAuthorize("false")
	@GetMapping("download/page")
	public String FileList(){
		return "download/page";
	}
	
	
	@GetMapping("download/page/{page}")
	public String FilePage(@PathVariable int page, @RequestParam(required = false) Integer num){
		if(null == num){
			num = WebConstant.PAGE_NUMBER; 
		}
		return "download/list";
	}
	
	//@Secured({"ROLE_USER"})
	@PostMapping("download/new/task")
	public String newTask(@RequestParam(required=true)String url,
			@RequestParam(required=false)Integer sortId, @RequestParam(required=false)String introduction,
			RedirectAttributes model){
		
		/*if(!Examine.isUrl(url)){
			model.addFlashAttribute("urlerror",1);
			return "redirect:/download/page#/new";
		}*/
		
		/*int availability = URLAvailability.isConnect(url);
		
		if(availability == 1){
			model.addFlashAttribute("urlerror",2);
			return "redirect:/download/page#/new";
		}*/
		downloadService.download(url, sortId, introduction);
		return "redirect:/download/page#/list";
	}
	
	@ResponseBody
	@GetMapping("download/task/list")
	public List<DownLoadTask> list(){
		return downloadService.list();
	}
}

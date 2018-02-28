package com.ciecc.fire.download.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciecc.fire.download.bean.AccountProperties;
import com.ciecc.fire.download.bean.MyYMLSetting;
import com.ciecc.fire.download.bean.Setting;
import com.ciecc.fire.download.bean.YMLSetting;
import com.ciecc.fire.download.domain.SetPojo;

@Controller
public class HelloController {
	
	@Autowired
	private Setting setting;
	
	@Autowired
	private YMLSetting yMLSetting;
	
	@Autowired
	private MyYMLSetting myYMLSetting;
	
	private final AccountProperties properties;

    @Autowired
    public HelloController(AccountProperties properties) {
        this.properties = properties;
    }

	@RequestMapping("/properties")
	@ResponseBody
	private String hello() {
		List<SetPojo> set = yMLSetting.getList();
		List<String> str = myYMLSetting.getServers();
		System.out.println(setting.getName() + setting.getSecret() + set.get(0).getName() + str.get(0) + properties.isEnabled());
		return "Hello world " + setting.getName();
	}
}

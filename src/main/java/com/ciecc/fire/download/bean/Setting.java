package com.ciecc.fire.download.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Setting {

	@Value("${author}")
    private String name;
	
	@Value("${my.secret}")
    private String secret; //只赋一次值,每次取值都是相同的

	public String getName() {
		return name;
	}
	
	public String getSecret() {
		return secret;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/
}

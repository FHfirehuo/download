package com.ciecc.fire.download.bean;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CommandArg{

		//        .child(Application.class) 必须加载了开始类才能获取参数
	public CommandArg(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
        System.out.println(debug);
        System.out.println(files);
	}

	
}

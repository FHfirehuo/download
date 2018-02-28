package com.ciecc.fire.download.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 如果你想获取原始的命令行参数，或一旦SpringApplication启动，你需要运行一些特定的代码，你可以实现CommandLineRunner接口。
 * 在所有实现该接口的Spring beans上将调用run(String… args)方法。
 * @author fire
 *
 */
@Component
public class CommandLine implements CommandLineRunner {
	
	@Autowired
	private StringRedisTemplate template;
		

	@Override
	public void run(String... args) throws Exception {
		System.out.println(args.length);
		System.out.println("CommandLine Sending message...");
		template.convertAndSend("chat", "Hello from Redis!");

	}

}

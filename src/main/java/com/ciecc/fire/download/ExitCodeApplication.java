package com.ciecc.fire.download;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class ExitCodeApplication {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 42;
			}
		};
	}

	public static void main(String[] args) {
		
		//此种方法不能传递命令行参数
		System.exit(SpringApplication
				.exit(SpringApplication.run(ExitCodeApplication.class, args)));
	}

}

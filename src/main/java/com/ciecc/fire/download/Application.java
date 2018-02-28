package com.ciecc.fire.download;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.ciecc.fire.download.domain.Email;

/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration
@EnableJms		// @ComponentScan
public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 如果您不想使用重新启动功能，则可以使用spring.devtools.restart.enabled属性将其禁用。
		 * 在大多数情况下，你可以在你的application.properties中设置它（这将仍然初始化重启类加载器，但它不会监视文件的变化）。
		 * 
		 * 如果您需要完全禁用重新启动支持，例如，因为它不适用于特定的库，则需要在调用SpringApplication.run（...）
		 * 之前设置System属性。 例如：
		 */
		//System.setProperty("spring.devtools.restart.enabled", "false");
		
		
		//SpringApplication.setAddCommandLineProperties(false);
		
		/**
		 * 默认情况下，SpringApplication将任何可选的命令行参数（以'--'开头，比如，--server.port=9000）转化为property，并将其添加到Spring Environment中。
		 * 如上所述，命令行属性总是优先于其他属性源。
		 * 如果你不想将命令行属性添加到Environment里，你可以使用SpringApplication.setAddCommandLineProperties(false)来禁止它们。
		 */
		//SpringApplication.run(Application.class, args);

		/*SpringApplication app = new SpringApplication(FireConfig.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setAddCommandLineProperties(false);
		app.run(args);*/
		
		
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
		.sources(Application.class)
        //.child(Application.class)
        .bannerMode(Banner.Mode.OFF)
        .addCommandLineProperties(false)
        .run(args);
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
        
		//latch.await();
		
	}

}

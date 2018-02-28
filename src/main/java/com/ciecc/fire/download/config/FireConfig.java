package com.ciecc.fire.download.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/***
 * 如果发现应用了你不想要的特定自动配置类，你可以使用@EnableAutoConfiguration注解的排除属性来禁用它们。
 * @author fire
 *
 */
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableConfigurationProperties(AccountProperties.class)
public class FireConfig {
	//程序加载完才能赋值
	@Value("${app.name}")
	private String app;

	public FireConfig() {
		System.out.println("FireConfig");
		System.out.println(app);
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
}

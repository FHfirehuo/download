package com.ciecc.fire.download.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * 跨源资源共享（CORS）是大多数浏览器实现的W3C规范，允许您以灵活的方式指定什么样的跨域请求被授权，而不是使用像IFRAME或JSONP那样的不太安全和功能较弱的方法。
 * 从4.2版开始，Spring MVC支持CORS开箱即用。
 *  使用控制器方法在Spring Boot应用程序中使用@CrossOrigin标注的CORS配置不需要任何特定的配置。 
 *  全局CORS配置可以通过使用定制的addCorsMappings（CorsRegistry）方法注册WebMvcConfigurer bean来定义：
 * @author fire
 * Cross-origin
 */
@Configuration
public class CORS {

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
        };
    }
}

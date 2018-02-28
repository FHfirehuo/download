package com.ciecc.fire.download.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ciecc.fire.download.security.DownloadUserDetailsService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(downloadUserDetailsService());
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/**").permitAll()
		.antMatchers("/download/**").authenticated()
		.antMatchers("/upload/**").authenticated()
		.antMatchers("/self/**").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")//.failureUrl("login-error")
		.permitAll()
		.and()
		.logout().logoutSuccessUrl("/").permitAll();
	}

	/**
	 * 这只有在AuthenticationManagerBuilder没有被填充并且没有定义AuthenticationProviderBean时才被使用。
	 * @return
	 */
	@Bean
	public DownloadUserDetailsService downloadUserDetailsService() {
		return new DownloadUserDetailsService();
	}
	
	/*@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		return manager;
	}*/
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/


}

package com.ciecc.fire.download.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ciecc.fire.download.domain.SecurityUser;
import com.ciecc.fire.download.domain.SecurityUser.Gender;

public class DownloadUserDetailsService implements UserDetailsService {
	
	private Map<String, SecurityUser> users = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(DownloadUserDetailsService.class);
	

	public DownloadUserDetailsService() {
		List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
		SecurityUser user = new SecurityUser("user", "fire", true, true, true, true, AUTHORITIES);
		user.setId(2);
		user.setNickname("刘燚");
		user.setSex(Gender.MALE);
		users.put("user", user);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();  
		//SecurityUser user = (SecurityUser) this.userCache.getUserFromCache(username);  
		//SecurityUser user = UserTool.getCurrentUser();
        /*if(user == null){  
            //user = this.sysUsersRepository.getByUsername(username);
        	user = users.get(username);
            if(user == null)  
                throw new UsernameNotFoundException("UserDetailsService.userNotFount");
            
            //得到用户的权限  
            auths = this.sysUsersRepository.loadUserAuthorities( username );  
              
            user.setAuthorities(auths);  
        }*/ 
		SecurityUser user = users.get(username);
		System.out.println("user1:" + user);
        if(user == null){
        	
        	throw new UsernameNotFoundException("UserDetailsService.userNotFount");
        }
        
        
        List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
      //  user.setAuthorities(AUTHORITIES); 	
        System.out.println("user2:" + user);
        
        logger.info("*********************"+username+"***********************");  
        //logger.info(user.getAuthorities().toString());  
        logger.info("********************************************************");  
          
        //this.userCache.putUserInCache(user);  
          
        return user;  
	}

}

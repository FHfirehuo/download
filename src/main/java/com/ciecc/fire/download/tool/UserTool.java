package com.ciecc.fire.download.tool;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ciecc.fire.download.domain.SecurityUser;

public class UserTool {

	public static SecurityUser getCurrentUser() {
		try {
			Object principle =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(principle instanceof UserDetails){
				return (SecurityUser)principle;
			}
			
			String username =  principle.toString();
			return new SecurityUser(username, username, false, false, false, false, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

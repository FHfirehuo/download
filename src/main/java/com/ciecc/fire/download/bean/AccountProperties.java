package com.ciecc.fire.download.bean;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @Component 和 EnableConfigurationProperties 不能同时使用会造成两个实例
 * @author fire
 * @see FireConfig
 */
@Component
@ConfigurationProperties("account")
public class AccountProperties {
	
	private boolean enabled;

    private InetAddress remoteAddress;

    private final Security security = new Security();

    public boolean isEnabled() {
    	return enabled;
    }

    public void setEnabled(boolean enabled) {
    	this.enabled = enabled;
    }

    public InetAddress getRemoteAddress() {
    	return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
    	this.remoteAddress = remoteAddress;
    }

    public Security getSecurity() {
    	return security;
    }

    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

        public String getUsername() {
        	return username;
        }

        public void setUsername(String username) {
        	
        }

        public String getPassword() {
        	return password;
        }

        public void setPassword(String password) {
}

        public List<String> getRoles() {
        	return roles;
        }

        public void setRoles(List<String> roles) {
        	
        }

    }

}

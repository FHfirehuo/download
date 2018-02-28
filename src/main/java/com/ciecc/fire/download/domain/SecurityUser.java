package com.ciecc.fire.download.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nickname;
	private Gender sex;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SecurityUser [id=").append(id).append(", nickname=").append(nickname).append(", sex=")
				.append(sex).append(",").append(super.toString()).append("]");
		return builder.toString();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public SecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public enum Gender {

		MALE(1), FEMALE(0);

		Gender(int value) {
			this.value = value;
		}

		private int value;

		public int getVlaue() {
			return value;
		}
	}

}

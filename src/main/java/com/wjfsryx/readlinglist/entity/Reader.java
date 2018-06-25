package com.wjfsryx.readlinglist.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Reader implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	
	private String fullname;
	
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("READER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	//不过期
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//不加锁
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//不过期
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//不禁用
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

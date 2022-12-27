//package com.example.demo;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.entities.UserEntity;
//
//public class CustomUserDetails implements UserDetails {
//
//	private UserEntity userEntity;
//	
//	public CustomUserDetails (UserEntity userEntity)
//	{
//		super();
//		this.userEntity = userEntity;
//	}
//
//
//	@Override
//	public String getPassword() {
//		return userEntity.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return userEntity.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}

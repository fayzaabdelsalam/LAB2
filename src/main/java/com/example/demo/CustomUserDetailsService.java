//package com.example.demo;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entities.UserEntity;
//import com.example.demo.repositories.UserRepository;
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//	@Autowired
//	private UserRepository userRepository;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserEntity userEntity = new UserEntity();
//		Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(username);
//		if(userEntityWrapper.isPresent())
//		{
//			userEntity = userEntityWrapper.get();
//		}
//		
//		return new CustomUserDetails(userEntity);
//	}
//
//}

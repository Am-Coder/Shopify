package com.example.herok.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.herok.enities.Role;
import com.example.herok.enities.User;
import com.example.herok.repositories.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	private final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	@Autowired
	private UserRepo repo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(username);

		Optional<User> getuser = repo.findByUsername(username);
		if(getuser.isPresent()) {
			User user = getuser.get();
			logger.info(user.toString());
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			for(Role role:user.getRole())
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
			
			
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
		}
		else {
			throw new UsernameNotFoundException("User 404");
		}

//		if(user==null)
//			throw new UsernameNotFoundException("User 404");
//		System.out.println(user.getRole());
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		
//			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
//		
//		
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
//		return new UserPrincipal(user);
	}


	
	
}

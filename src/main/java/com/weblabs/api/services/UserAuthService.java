package com.weblabs.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.weblabs.api.models.AuthModel;
import com.weblabs.api.models.UserModel;
import com.weblabs.api.repositories.UsersRepository;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserModel> user = userRepository.findByUsername(username);
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		UserModel result = null;
		if(user.isPresent()) {	
			result = user.get();
			for(AuthModel auth: user.get().authorities) {
				auths.add(new SimpleGrantedAuthority(auth.name));
			}
		}
		
		return new User(result.username,result.password,auths);
	}

}

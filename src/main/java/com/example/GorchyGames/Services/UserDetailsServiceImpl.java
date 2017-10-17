package com.example.GorchyGames.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
import com.example.GorchyGames.Models.User;
import com.example.GorchyGames.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		 User user = this.userRepository.findByUserName(username);
	     if (user == null) {
	         throw new UsernameNotFoundException(username);
	     }
	     return (UserDetails) new User(user.getId(),user.getUserName(), user.getPassWord());
	}
	
 
}

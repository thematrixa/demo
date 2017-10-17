package com.example.GorchyGames.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.GorchyGames.Models.User;
import com.example.GorchyGames.Services.UserService;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{


	public CustomAuthenticationProvider() {
		super();
	}

	@Autowired
	UserService userService;

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

			User user = userService.getByUserName(name);
			Authentication auth = new UsernamePasswordAuthenticationToken(user, password);
			if (user.getPassWord().equals(password)) {
				return auth;
			} else {
				return null;
			}
		
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}

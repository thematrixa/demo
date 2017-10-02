package com.example.GorchyGames.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GorchyGames.Models.User;
import com.example.GorchyGames.Repository.UserRepositoryImpl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepositoryImpl userRepository;

	@Override
	public void createUser(User us) {
		// TODO Auto-generated method stub
		
	}

}

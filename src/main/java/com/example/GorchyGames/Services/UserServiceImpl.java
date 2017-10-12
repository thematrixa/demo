package com.example.GorchyGames.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.GorchyGames.Models.User;
import com.example.GorchyGames.Repository.UserRepositoryImpl;
import com.example.GorchyGames.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepositoryImpl userRepository;

	@RequestMapping("/add")
	@Override
	public User createUser(User us) {
		return this.userRepository.save(us);
	}
	@Override
	public User update(User us) {
		if(userRepository.exists(us.getId())) {
			return this.userRepository.save(us);
		}
		else {
			return null;
		}
	}
	@Override
	public void delete(Long id) {
		this.userRepository.delete(id);
	}
	@Override
	public User getById(Long id) {
		return userRepository.findOne(id); 
	}
	@Override
	public Iterable<User> getAll() {
		return this.userRepository.findAll();
	}
	@Override
	public boolean exists(Long id) {
		return this.userRepository.exists(id);
	}

}

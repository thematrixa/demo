package com.example.GorchyGames.Services;

import com.example.GorchyGames.Models.User;

public interface UserService {
	
	public User createUser(User us) ;
	public User update(User us) ;
	public void delete(Long id);
	public User getById(Long id);
	public User getByUserName(String username);
	public Iterable<User> getAll();
	boolean exists(Long id);
	boolean exists(String string);
}
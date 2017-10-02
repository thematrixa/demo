package com.example.GorchyGames.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.GorchyGames.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	
	
}

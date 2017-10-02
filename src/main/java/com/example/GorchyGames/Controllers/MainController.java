package com.example.GorchyGames.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.GorchyGames.Models.User;
import com.example.GorchyGames.Repository.UserRepository;

@Controller
@RequestMapping("/gorchygames")
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String pass) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setUserName(name);
		n.setPassWord(pass);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/remove")
	public @ResponseBody String deleteUser(@RequestParam Long id) {
		userRepository.delete(id);
		return "Deleted";
	}
	
	@PostMapping(path = "/update") // Map ONLY GET Requests
	public @ResponseBody String updateUser(@RequestBody User us) {
	
		userRepository.save(us);
		return "Updated";
	}
	

}

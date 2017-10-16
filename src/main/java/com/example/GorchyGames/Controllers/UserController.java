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
import com.example.GorchyGames.Services.UserService;

@Controller
@RequestMapping("/gorchygames/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody User addNewUser(@RequestBody User us) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		return userService.createUser(us);
	}

	@GetMapping(path = "/user") // Map ONLY GET Requests
	public @ResponseBody User getUserById(@RequestParam Long id) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		return userService.getById(id);
	}

	@GetMapping(path = "/login") // Map ONLY GET Requests
	public @ResponseBody User login(@RequestParam User user) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		if (userService.exists(user.getUserName())) {
			return userService.getByUserName(user.getUserName());
		} else {
			return null;
		}
	}

	@GetMapping(path = "/getAll") // Map ONLY GET Requests
	public @ResponseBody Iterable<User> getAllUsers() {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		return userService.getAll();
	}

	@GetMapping(path = "/delete") // Map ONLY GET Requests
	public @ResponseBody String delete(@RequestParam Long id) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		userService.delete(id);
		if (userService.exists(id)) {
			return "Unsuccessful";
		} else {
			return "Success";
		}
	}

	@PostMapping(path = "/update") // Map ONLY GET Requests
	public @ResponseBody User updateUser(@RequestBody User us) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		return userService.update(us);
	}

}

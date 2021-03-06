package com.example.GorchyGames.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> addNewUser(@RequestBody User user) {
		
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_PLAIN);
        try {
            String username = user.getUserName();
            User userDb = this.userService.getByUserName(username);
            if (username == null) {
                return new ResponseEntity<>("You didnt type in a username!", header,  HttpStatus.NOT_FOUND);
            }
            if (userDb!= null) {
                return new ResponseEntity<>("Username is already taken!", header, HttpStatus.NOT_FOUND);
            }
            userService.createUser(user);
            return new ResponseEntity<>("Registration Successful!", header, HttpStatus.OK);
        } catch (Exception e) {
        	
            return new ResponseEntity<>("Server problem", header, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@GetMapping(path = "/user") // Map ONLY GET Requests
	public @ResponseBody User getUserById(@RequestParam Long id) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		return userService.getById(id);
	}
/*
	@PostMapping(path = "/login") // Map ONLY GET Requests
	public @ResponseBody User login(@RequestBody User user) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		User userFromDB = userService.getByUserName(user.getUserName());

		if (userFromDB != null && user.getPassWord().equals(userFromDB.getPassWord())) {
			return userFromDB;
		} else {
			return null;
		}
	}*/

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

	@GetMapping(path = "/de") // Map ONLY GET Requests
	public @ResponseBody String delete() {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		return "gpgp";
	}

	@PostMapping(path = "/update") // Map ONLY GET Requests
	public @ResponseBody User updateUser(@RequestBody User us) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		return userService.update(us);
	}

}

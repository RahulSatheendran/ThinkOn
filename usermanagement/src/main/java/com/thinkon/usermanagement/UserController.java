package com.thinkon.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	//create a new user
	@PostMapping
	public ResponseEntity<UserEntity> createNewUser(@RequestBody UserEntity userEntity){
		return ResponseEntity.ok(userService.createNewUser(userEntity));
	}

	//get all users
	@GetMapping
	public List<UserEntity> getAllUsers(){
		return userService.findAllUsers();
	}

	//find a single user
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){

		return ResponseEntity.ok(userService.findUser(id));

		//return userService.findUser(id).

		/*
		 * return userService.findUser(id) .map(ResponseEntity::ok)
		 * .orElse(ResponseEntity.notFound().build());
		 */
	}

	//update an existing user
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(userService.updateUser(id, userEntity));
	}

	//delete a user by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
} 
package com.thinkon.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity createNewUser(UserEntity user) {
		return userRepository.save(user);
	}

	@SuppressWarnings("deprecation")
	public UserEntity findUser(Long id) {
		return userRepository.getById(id);
	}

	public List<UserEntity> findAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public UserEntity updateUser(Long id, UserEntity user) {

		UserEntity updatedUser = findUser(id);
		if(null != updatedUser) {

			updatedUser.setUserName(user.getUserName());
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPhoneNumber(user.getPhoneNumber());
		}

		return userRepository.save(updatedUser);

	}
}

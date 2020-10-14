package info.infoPet.service;

import org.springframework.stereotype.Service;

import info.infoPet.model.User;
import info.infoPet.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepositroy) {
		this.userRepository = userRepositroy;
	}
	
	public User findByUserEmailAndName (String email , String name) {
		return userRepository.findByEmailAndName(email, name);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
}

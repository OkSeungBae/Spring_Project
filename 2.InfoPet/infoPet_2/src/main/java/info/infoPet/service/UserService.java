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
	
	public User findByUserEmailOrName (String email , String name) {
		return userRepository.findByEmailOrName(email, name);
	}
	
	public User findByUserEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
}

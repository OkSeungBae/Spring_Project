package info.infoPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.infoPet.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailOrName(String email, String name);
	User findByEmailAndPassword(String email, String password);
}

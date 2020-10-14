package info.infoPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.infoPet.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}

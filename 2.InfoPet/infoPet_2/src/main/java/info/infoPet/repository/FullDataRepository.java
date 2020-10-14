package info.infoPet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.infoPet.model.User;

public interface FullDataRepository extends JpaRepository<User, Integer>{
	
}

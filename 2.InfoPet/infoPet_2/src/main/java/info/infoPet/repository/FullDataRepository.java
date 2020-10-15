package info.infoPet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info.infoPet.model.FullData;
import info.infoPet.model.User;

public interface FullDataRepository extends JpaRepository<FullData, String>{
	List<FullData> findByName(String name);
	
}

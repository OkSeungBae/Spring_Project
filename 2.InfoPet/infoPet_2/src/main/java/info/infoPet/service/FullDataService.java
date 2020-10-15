package info.infoPet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import info.infoPet.model.FullData;
import info.infoPet.model.User;
import info.infoPet.repository.FullDataRepository;
import info.infoPet.repository.UserRepository;

@Service
public class FullDataService {
	private final FullDataRepository fullDataRepository;
	
	public FullDataService(FullDataRepository fullDataRepositroy) {
		this.fullDataRepository = fullDataRepositroy;
	}

	public List<FullData> findByName(String name) {
		return fullDataRepository.findByName(name);
	}
	/*
	public FullData findByUserEmailOrName (String email , String name) {
		//return fullDataRepository.findByEmailOrName(email, name);
	}*/
	
}

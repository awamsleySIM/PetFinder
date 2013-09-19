package com.systemsinmotion.petfinder.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petfinder.dao.IPetfinderDAO;
import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;

@Service("petfinderService")
public class PetfinderService {

	@Autowired
	private IPetfinderDAO petfinderDAO;

	public PetfinderPetRecord findRandomPet() {
		return petfinderDAO.findRandomPet();
	}

	public PetfinderPetRecord findRandomPet(Map<String, String> options) {
		return petfinderDAO.findRandomPet(options);
	}

	public PetfinderBreedList findBreedList(AnimalType animalType) {
		return petfinderDAO.findBreedList(animalType);
	}

	public PetfinderPetRecord findPetById(Integer id) {
		return petfinderDAO.findPetById(id);
	}

	public Petfinder findPet(Map<String, String> options) {
		return petfinderDAO.findPet(options);
	}
	
	public void setPetfinderDAO(IPetfinderDAO mockPetfinderDAO) {
		this.petfinderDAO = mockPetfinderDAO;
	}
	
}

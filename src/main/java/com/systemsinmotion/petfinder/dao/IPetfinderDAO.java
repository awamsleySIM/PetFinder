package com.systemsinmotion.petfinder.dao;

import java.util.Map;

import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;

public interface IPetfinderDAO {

	public abstract PetfinderPetRecord findRandomPet();

	public abstract PetfinderPetRecord findRandomPet(Map<String, String> options);

	public abstract PetfinderBreedList findBreedList(AnimalType animalType);

	public abstract PetfinderPetRecord findPetById(Integer id);

	public abstract Petfinder findPet(Map<String, String> options);

}
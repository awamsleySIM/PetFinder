package com.systemsinmotion.petfinder.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.systemsinmotion.petfinder.api.API;
import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecordList;


@Repository("petfinderDAO")
public class PetfinderDAO {

	@Autowired
	private RestTemplate restTemplate;
	
	public PetfinderPetRecord findRandomPet() {
		return this.restTemplate.getForObject(API.GET_RANDOM + "&output=basic", Petfinder.class).getPet();
	}
	
	public PetfinderPetRecord findRandomPet(Map<String, String> options) {
		String url = API.GET_RANDOM;
		for (String key : options.keySet()) {
			url += "&" + key + "=" + options.get(key);
		}
		return this.restTemplate.getForObject(url, Petfinder.class).getPet();
	}
	
	public PetfinderBreedList findBreedList(AnimalType animalType) {
		String url = API.BREED_LIST + "&animal=" + animalType.value();
		return this.restTemplate.getForObject(url, Petfinder.class).getBreeds();
	}
	
	public PetfinderPetRecord findPetById(Integer id) {
		String url = API.GET + "&id=" + id;
		return this.restTemplate.getForObject(url, Petfinder.class).getPet();
	}
	
	public PetfinderPetRecordList findPet(Map<String, String> options) {
		String url = API.FIND;
		for (String key : options.keySet()) {
			url += "&" + key + "=" + options.get(key);
		}
		return this.restTemplate.getForObject(url, Petfinder.class).getPets();
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public RestTemplate getRestTemplate() {
		return this.restTemplate;
	}
	
}
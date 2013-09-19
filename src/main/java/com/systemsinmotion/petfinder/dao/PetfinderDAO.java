package com.systemsinmotion.petfinder.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;
import com.systemsinmotion.petfinder.web.API;


@Repository("petfinderDAO")
public class PetfinderDAO implements IPetfinderDAO {

	@Autowired
	private RestTemplate restTemplate;
	
	/* (non-Javadoc)
	 * @see com.systemsinmotion.petfinder.dao.IPetfinderDAO#findRandomPet()
	 */
	@Override
	public PetfinderPetRecord findRandomPet() {
		return this.restTemplate.getForObject(API.GET_RANDOM, Petfinder.class).getPet();
	}
	
	/* (non-Javadoc)
	 * @see com.systemsinmotion.petfinder.dao.IPetfinderDAO#findRandomPet(java.util.Map)
	 */
	@Override
	public PetfinderPetRecord findRandomPet(Map<String, String> options) {
		String url = API.GET_RANDOM;
		for (String key : options.keySet()) {
			url += "&" + key + "=" + options.get(key);
		}
		return this.restTemplate.getForObject(url, Petfinder.class).getPet();
	}
	
	/* (non-Javadoc)
	 * @see com.systemsinmotion.petfinder.dao.IPetfinderDAO#findBreedList(com.systemsinmotion.petfinder.entities.AnimalType)
	 */
	@Override
	public PetfinderBreedList findBreedList(AnimalType animalType) {
		String url = API.BREED_LIST + "&animal=" + animalType.value().toLowerCase();
		return this.restTemplate.getForObject(url, Petfinder.class).getBreeds();
	}
	
	/* (non-Javadoc)
	 * @see com.systemsinmotion.petfinder.dao.IPetfinderDAO#findPetById(java.lang.Integer)
	 */
	@Override
	public PetfinderPetRecord findPetById(Integer id) {
		String url = API.GET + "&id=" + id;
		return this.restTemplate.getForObject(url, Petfinder.class).getPet();
	}
	
	/* (non-Javadoc)
	 * @see com.systemsinmotion.petfinder.dao.IPetfinderDAO#findPet(java.util.Map)
	 */
	@Override
	public Petfinder findPet(Map<String, String> options) {
		String url = API.FIND;
		for (String key : options.keySet()) {
			url += "&" + key + "=" + options.get(key);
		}
		return this.restTemplate.getForObject(url, Petfinder.class);
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public RestTemplate getRestTemplate() {
		return this.restTemplate;
	}
	
}

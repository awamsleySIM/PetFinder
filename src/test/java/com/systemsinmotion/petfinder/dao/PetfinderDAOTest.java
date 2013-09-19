package com.systemsinmotion.petfinder.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;
import com.systemsinmotion.petfinder.web.API;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class PetfinderDAOTest {
	
	@Autowired
	private PetfinderDAO petfinderDAO;
	
	private Map<String, String> options;
	private AnimalType animalType = AnimalType.CAT;
	
	private RestTemplate mockRestTemplate = mock(RestTemplate.class);
	
	private Petfinder mockPetfinder = mock(Petfinder.class);
	private PetfinderPetRecord mockPetfinderPetRecord = mock(PetfinderPetRecord.class);
	private PetfinderBreedList mockPetfinderBreedList = mock(PetfinderBreedList.class);
	
	@Before
	public void before() {
		options = new HashMap<String, String>();
		
		when(mockPetfinder.getPet()).thenReturn(mockPetfinderPetRecord);
		when(mockPetfinder.getBreeds()).thenReturn(mockPetfinderBreedList);
		
		when(mockRestTemplate.getForObject(API.BREED_LIST + "&animal=cat", Petfinder.class)).thenReturn(mockPetfinder);
		when(mockRestTemplate.getForObject(API.GET_RANDOM, Petfinder.class)).thenReturn(mockPetfinder);
		when(mockRestTemplate.getForObject(API.GET + "&id=1", Petfinder.class)).thenReturn(mockPetfinder);
		when(mockRestTemplate.getForObject(API.FIND, Petfinder.class)).thenReturn(mockPetfinder);
		
		petfinderDAO.setRestTemplate(mockRestTemplate);
	}
	
	@Test
	public void findRandomPet() {
		PetfinderPetRecord returnValue = petfinderDAO.findRandomPet();
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void findRandomPet_WithOptions() {
		PetfinderPetRecord returnValue = petfinderDAO.findRandomPet(options);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void findBreedList() {
		PetfinderBreedList returnValue = petfinderDAO.findBreedList(animalType);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderBreedList, returnValue);
	}
	
	@Test
	public void findPetById() {
		PetfinderPetRecord returnValue = petfinderDAO.findPetById(1);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void findPet() {
		Petfinder returnValue = petfinderDAO.findPet(options);
		assertNotNull(returnValue);
		assertEquals(mockPetfinder, returnValue);
	}
	
}

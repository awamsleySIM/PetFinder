package com.systemsinmotion.petfinder.services;

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

import com.systemsinmotion.petfinder.dao.IPetfinderDAO;
import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class PetfinderServiceTest {
	
	@Autowired
	private PetfinderService petfinderService;
	
	private IPetfinderDAO mockPetfinderDAO = mock(IPetfinderDAO.class);
	private Petfinder mockPetfinder = mock(Petfinder.class);
	private PetfinderPetRecord mockPetfinderPetRecord = mock(PetfinderPetRecord.class);
	private PetfinderBreedList mockPetfinderBreedList = mock(PetfinderBreedList.class);
	
	private Map<String, String> options;
	private AnimalType animalType = AnimalType.CAT;
	
	@Before
	public void before() {
		options = new HashMap<String, String>();
		
		when(mockPetfinderDAO.findRandomPet()).thenReturn(mockPetfinderPetRecord);
		when(mockPetfinderDAO.findRandomPet(options)).thenReturn(mockPetfinderPetRecord);
		when(mockPetfinderDAO.findBreedList(animalType)).thenReturn(mockPetfinderBreedList);
		when(mockPetfinderDAO.findPetById(1)).thenReturn(mockPetfinderPetRecord);
		when(mockPetfinderDAO.findPet(options)).thenReturn(mockPetfinder);
		
		petfinderService.setPetfinderDAO(mockPetfinderDAO);
	}
	
	@Test
	public void findRandomPet() {
		PetfinderPetRecord returnValue = petfinderService.findRandomPet();
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void findRandomPetWithOptions() {
		PetfinderPetRecord returnValue = petfinderService.findRandomPet(options);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void findBreedList() {
		PetfinderBreedList returnValue = petfinderService.findBreedList(animalType);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderBreedList, returnValue);
	}
	
	@Test
	public void findPetById() {
		PetfinderPetRecord returnValue = petfinderService.findPetById(1);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void findPet() {
		Petfinder returnValue = petfinderService.findPet(options);
		assertNotNull(returnValue);
		assertEquals(mockPetfinder, returnValue);
	}
	
}

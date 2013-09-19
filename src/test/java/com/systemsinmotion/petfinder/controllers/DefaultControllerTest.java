package com.systemsinmotion.petfinder.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;
import com.systemsinmotion.petfinder.services.PetfinderService;
import com.systemsinmotion.petfinder.web.Views;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class DefaultControllerTest {
	
	@Autowired
	private DefaultController controller;
	
	private Map<String, String> options;
	private PetfinderService mockPetfinderService = mock(PetfinderService.class);
	private PetfinderPetRecord mockPetfinderPetRecord = mock(PetfinderPetRecord.class);
	private Petfinder mockPetfinder = mock(Petfinder.class);
	private PetfinderBreedList mockPetfinderBreedList = mock(PetfinderBreedList.class);
	private AnimalType animalType = AnimalType.CAT;
	
	
	@Before
	public void before() {
		options = new HashMap<String, String>();
		
		when(mockPetfinderService.findRandomPet()).thenReturn(mockPetfinderPetRecord);
		when(mockPetfinderService.findRandomPet(options)).thenReturn(mockPetfinderPetRecord);
		when(mockPetfinderService.findBreedList(animalType)).thenReturn(mockPetfinderBreedList);
		when(mockPetfinderService.findPet(options)).thenReturn(mockPetfinder);
		when(mockPetfinderService.findPetById(1)).thenReturn(mockPetfinderPetRecord);
		controller.setPetfinderService(mockPetfinderService);
	}
	
	@Test
	public void doIndex() {
		String returnValue = controller.doIndex();
		assertNotNull(returnValue);
		assertEquals(Views.INDEX, returnValue);
	}
	
	@Test
	public void doRandomPetView() {
		String returnValue = controller.doRandomPetView();
		assertNotNull(returnValue);
		assertEquals(Views.RANDOMPET, returnValue);
	}
	
	@Test
	public void doFindRandomPetWithOptions() {
		PetfinderPetRecord returnValue = controller.doFindRandomPetWithOptions(options);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void doFindRandomPet() {
		PetfinderPetRecord returnValue = controller.doFindRandomPet();
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
	
	@Test
	public void doFindPetMenuView() {
		String returnValue = controller.doFindPetMenuView();
		assertNotNull(returnValue);
		assertEquals(Views.FINDPETMENU, returnValue);
	}
	
	@Test
	public void doFindPetView() {
		String returnValue = controller.doFindPetView(options);
		assertNotNull(returnValue);
		assertEquals(Views.FINDPET, returnValue);
	}
	
	@Test
	public void doFindPetList() {
		Petfinder returnValue = controller.doFindPetList(options);
		assertNotNull(returnValue);
		assertEquals(mockPetfinder, returnValue);
	}
	
	@Test
	public void doGetBreedList() {
		PetfinderBreedList returnValue = controller.doGetBreedList(animalType.value());
		assertNotNull(returnValue);
		assertEquals(mockPetfinderBreedList, returnValue);
	}
	
	@Test
	public void doViewPetView() {
		String returnValue = controller.doViewPetView();
		assertNotNull(returnValue);
		assertEquals(Views.VIEWPET, returnValue);
	}
	
	@Test
	public void doFindPetById() {
		PetfinderPetRecord returnValue = controller.doFindPetById(1);
		assertNotNull(returnValue);
		assertEquals(mockPetfinderPetRecord, returnValue);
	}
}

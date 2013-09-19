package com.systemsinmotion.petfinder.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.systemsinmotion.petfinder.entities.AnimalType;
import com.systemsinmotion.petfinder.entities.Petfinder;
import com.systemsinmotion.petfinder.entities.PetfinderBreedList;
import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;
import com.systemsinmotion.petfinder.services.PetfinderService;
import com.systemsinmotion.petfinder.web.Views;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	@Autowired
	private PetfinderService petfinderService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String doIndex() {
		return Views.INDEX;
	}
	
	@RequestMapping(value = "random", method = RequestMethod.GET)
	public String doRandomPetView() {
		return Views.RANDOMPET;
	}
	
	@RequestMapping(value = "randompetoptions", method = RequestMethod.GET)
	public @ResponseBody PetfinderPetRecord doFindRandomPetWithOptions(@RequestParam Map<String, String> options) {
		return petfinderService.findRandomPet(options);
	}
	
	@RequestMapping(value = "randompet", method = RequestMethod.GET)
	public @ResponseBody PetfinderPetRecord doFindRandomPet() {
		return petfinderService.findRandomPet();
	}
	
	@RequestMapping(value = "findpetmenu", method = RequestMethod.GET)
	public String doFindPetMenuView() {
		return Views.FINDPETMENU;
	}
	
	@RequestMapping(value = "findpet", method = RequestMethod.GET)
	public String doFindPetView(@RequestParam Map<String, String> options) {
		return Views.FINDPET;
	}
	
	@RequestMapping(value = "findpetlist", method = RequestMethod.GET)
	public @ResponseBody Petfinder doFindPetList(@RequestParam Map<String, String> options) {
		return petfinderService.findPet(options);
	}
	
	@RequestMapping(value = "breedlist", method = RequestMethod.GET)
	public @ResponseBody PetfinderBreedList doGetBreedList(@RequestParam(value = "animal") String animal) {
		return petfinderService.findBreedList(AnimalType.fromValue(animal));
	}
	
	@RequestMapping(value = "viewpet", method = RequestMethod.GET)
	public String doViewPetView() {
		return Views.VIEWPET;
	}
	
	@RequestMapping(value = "findpetbyid", method = RequestMethod.GET)
	public @ResponseBody PetfinderPetRecord doFindPetById(@RequestParam(value = "id") Integer id) {
		return petfinderService.findPetById(id);
	}
	
	public void setPetfinderService(PetfinderService mockPetfinderService) {
		this.petfinderService = mockPetfinderService;
	}
	
}

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

@Controller
@RequestMapping("/")
public class DefaultController {
	
	@Autowired
	private PetfinderService petfinderService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String doDefault_GET() {
		return "index";
	}
	
	@RequestMapping(value = "random", method = RequestMethod.GET)
	public String doRandom_GET() {
		return "randompet";
	}
	
	@RequestMapping(value = "randompetoptions", method = RequestMethod.GET)
	public @ResponseBody PetfinderPetRecord doGetRandomPetWithOptions(@RequestParam Map<String, String> options) {
		return petfinderService.findRandomPet(options);
	}
	
	@RequestMapping(value = "randompet", method = RequestMethod.GET)
	public @ResponseBody PetfinderPetRecord doGetRandomPet() {
		return petfinderService.findRandomPet();
	}
	
	@RequestMapping(value = "findpetmenu", method = RequestMethod.GET)
	public String doFindPetMenu_GET() {
		return "findpetmenu";
	}
	
	@RequestMapping(value = "findpet", method = RequestMethod.GET)
	public String doFindPet_POST(@RequestParam Map<String, String> options) {
		return "findpet";
	}
	
	@RequestMapping(value = "findpetlist", method = RequestMethod.GET)
	public @ResponseBody Petfinder doFindPetList(@RequestParam Map<String, String> options) {
		return petfinderService.findPet(options);
	}
	
	@RequestMapping(value = "breedlist", method = RequestMethod.GET)
	public @ResponseBody PetfinderBreedList doGetBreedList(@RequestParam(value = "animal") String animal) {
		return petfinderService.findBreedList(AnimalType.fromValue(animal));
	}
	
}

package com.systemsinmotion.petfinder.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.systemsinmotion.petfinder.entities.PetfinderPetRecord;
import com.systemsinmotion.petfinder.services.PetfinderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PetfinderService petfinderService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		PetfinderPetRecord randomPetRecord = petfinderService.findRandomPet();
		String petName = randomPetRecord.getName();
		String photoURL = randomPetRecord.getMedia().getPhotos().getPhoto().get(0).getValue();
		
		model.addAttribute("petName", petName);
		model.addAttribute("photoURL", photoURL);
		
		return "home";
	}
	
}

package edu.mu.adopt.model.pet;

import java.util.List;

public class ShelterManager {
	
	private static ShelterManager instance;
	private Shelter<Pet> shelter = new Shelter<Pet>();
	
	//constructor that prevents shelter from being instantiated from outside
	public ShelterManager() {
		
	}
	
	/**
	 * 
	 * */
	public static ShelterManager getInstance() {
		if(instance == null) {
			instance = new ShelterManager ();
		}
		return instance;
	}
	
	/**
	 * 
	 * */
	public Shelter<Pet> getShelter() {
		
		LoadPets loader = new LoadPets();
		List<Pet> listOfPets = loader.loadPets("src/main/resources/pets.json");
		
		for (int i = 0; i < listOfPets.size(); i++) {
			shelter.add(listOfPets.get(i));
		}
		
		List<Pet> listOfExoticPets = loader.loadExoticPets("src/main/resources/exotic_animals.json");
		for (int i = 0; i < listOfExoticPets.size(); i++) {
			shelter.add(listOfExoticPets.get(i));
		}
		
		return shelter;
	}

}

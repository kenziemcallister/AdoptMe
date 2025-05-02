package edu.mu.adopt.pet;

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
		
		return shelter;
	}

}

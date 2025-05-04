package edu.mu.adopt.model.pet;

import java.util.List;

public class ShelterManager {
	
	private static ShelterManager instance;
	private Shelter<Pet> shelter = new Shelter<Pet>();
	
	/**
	 * Constructor that prevents the shelter from loading in pets more than once.
	 */
	public ShelterManager() {
		loadPets(); //loading pets only once
	}
	
	/**
	 * This method is used to get the shelter manager instance.
	 * Follows singleton design pattern.
	 * */
	public static ShelterManager getInstance() {
		if(instance == null) {
			instance = new ShelterManager ();
		}
		return instance;
	}
	
	/**
	 * Helper method to make sure pets are only loaded in once from the JSON files.
	 */
	private void loadPets() {
		LoadPets loader = new LoadPets();
		List<Pet> listOfPets = loader.loadPets("src/main/resources/pets.json");
		
		for (int i = 0; i < listOfPets.size(); i++) {
			shelter.add(listOfPets.get(i));
		}
		
		List<Pet> listOfExoticPets = loader.loadExoticPets("src/main/resources/exotic_animals.json");
		for (int i = 0; i < listOfExoticPets.size(); i++) {
			shelter.add(listOfExoticPets.get(i));
		}
	}
	
	/**
	 * This is a getter used to get the shelter from the shelter manager.
	 * */
	public Shelter<Pet> getShelter() {
		return shelter;
	}

}

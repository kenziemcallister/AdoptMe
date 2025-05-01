package edu.mu.adopt.pet;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	public ExoticAnimalAdapter(ExoticAnimal exoticPet) {
		super(exoticPet.getUniqueId(), exoticPet.getAnimalName(), exoticPet.getCategory(), 
				exoticPet.getSubSpecies(), exoticPet.getYearsOld());
		this.exoticAnimal = exoticPet;
		
	}
	
	

}

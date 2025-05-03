package edu.mu.adopt.model.pet;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exotic;
	
	public ExoticAnimalAdapter(ExoticAnimal exotic) {
		super(exotic.getUniqueId(), exotic.getAnimalName(), exotic.getCategory(), exotic.getSubSpecies(), exotic.getYearsOld());
		this.exotic = exotic;
	}

}

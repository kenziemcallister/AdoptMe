package edu.mu.adopt.model.pet;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exotic;
	
	/**
	 * This is the constructor for an exotic animal adapter. 
	 * We wrap the given exotic animal as a pet, as this class extends a Pet,
	 * but an exotic animal does not.
	 * @param exotic
	 * 		The Exotic Animal that needs to be wrapped as a Pet.
	 */
	public ExoticAnimalAdapter(ExoticAnimal exotic) {
		super(exotic.getUniqueId(), exotic.getAnimalName(), exotic.getCategory(), exotic.getSubSpecies(), exotic.getYearsOld()); //setting fields as a pet's fields
		this.exotic = exotic; //setting the exotic animal to be wrapped
	}

}

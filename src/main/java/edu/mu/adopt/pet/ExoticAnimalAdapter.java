package edu.mu.adopt.pet;

public class ExoticAnimalAdapter implements PetSelection {
	
	private ExoticAnimal exoticAnimal;

	public ExoticAnimalAdapter(ExoticAnimal exoticPet) {
		this.exoticAnimal = exoticPet;	
	}
	
	private class ConvertExoticPet extends Pet {

		public ConvertExoticPet(int id, String name, String type, String species, int age) {
			super(id, name, type, species, age);
		
		}
		
	}

	@Override
	public void addPet() {
		
		
	}
	
	

}

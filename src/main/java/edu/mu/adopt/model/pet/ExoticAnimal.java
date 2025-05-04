package edu.mu.adopt.model.pet;

public class ExoticAnimal {
	
	String uniqueId;
	String animalName;
	String category;
	String subSpecies;
	int yearsOld;
	
	/**
	 * This is the constructor for creating an exotic animal. You must pass in the parameters.
	 * @param uniqueId
	 * 		This is the ID for the animal.
	 * @param animalName
	 * 		This is the animal's name.
	 * @param category
	 * 		This is the category the animal resides in.
	 * @param subSpecies
	 * 		This is the sub species the animal is.
	 * @param yearsOld
	 * 		This is the animal's age.
	 */
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
	}
	
	/**
	 * This is the getter for the unique ID.
	 * @return
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	
	/**
	 * This is the method to set an animal's unique ID.
	 * @param uniqueId
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	/**
	 * This is the getter for an animal's name.
	 * @return
	 */
	public String getAnimalName() {
		return animalName;
	}
	
	/**
	 * This is the setter for an animal's name.
	 * @param animalName
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	
	/**
	 * This is the getter for the animal's category.
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * This is a method used to set an animal's category.
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * This is a getter for an animal's sub species.
	 * @return
	 */
	public String getSubSpecies() {
		return subSpecies;
	}
	
	/**
	 * This is a method used to set an animal's sub species.
	 * @param subSpecies
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}
	
	/**
	 * This method is used to get an animal's age.
	 * @return
	 */
	public int getYearsOld() {
		return yearsOld;
	}
	
	/**
	 * This is a method used to set an animal's age.
	 * @param yearsOld
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	

}

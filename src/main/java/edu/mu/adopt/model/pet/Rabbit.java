package edu.mu.adopt.model.pet;

public class Rabbit extends Pet {

	/* Default constructor for the Rabbit class
	 * @param id (String)
	 *     This argument represents the id of the rabbit.
	 * @param name (String)
	 *     This argument represents the name of the rabbit.
	 * @param type (String)
	 *     This argument represents the rabbit class.
	 * @param species (String)
	 *     This argument represents the species of the rabbit.
	 * @param age (int)
	 *     This argument represents the age of the rabbit.
	 * */
	public Rabbit(String id, String name, String type, String species, int age) {
		super(id, name, type, species, age);	
		this.type = "Rabbit";
	}
	
	

	
}

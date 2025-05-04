package edu.mu.adopt.model.pet;

public class Dog extends Pet {

	/* Default constructor for the Dog class
	 * @param id (String)
	 *     This argument represents the id of the dog.
	 * @param name (String)
	 *     This argument represents the name of the dog.
	 * @param type (String)
	 *     This argument represents the dog class.
	 * @param species (String)
	 *     This argument represents the species of the dog.
	 * @param age (int)
	 *     This argument represents the age of the dog.
	 * */
	public Dog(String id, String name, String type, String species, int age) {
		super(id, name, type, species, age);
		this.type = "Dog";
	}

}

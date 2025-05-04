package edu.mu.adopt.model.pet;

public class Cat extends Pet{

	/* Default constructor for the Cat class
	 * @param id (String)
	 *     This argument represents the id of the cat.
	 * @param name (String)
	 *     This argument represents the name of the cat.
	 * @param type (String)
	 *     This argument represents the cat class.
	 * @param species (String)
	 *     This argument represents the species of the cat.
	 * @param age (int)
	 *     This argument represents the age of the cat.
	 * */
	public Cat(String id, String name, String type, String species, int age) {
		super(id, name, type, species, age);
		this.type = "Cat";
	}

}

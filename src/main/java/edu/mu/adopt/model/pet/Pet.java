package edu.mu.adopt.model.pet;

public abstract class Pet implements Comparable <Pet> {
	
	String id;
	String name;
	String type;
	String species;
	int age;
	boolean adopted;
	
	/* Default constructor for the Pet class
	 * @param id (String)
	 *     This argument represents the id of the pet.
	 * @param name (String)
	 *     This argument represents the name of the pet.
	 * @param type (String)
	 *     This argument represents the pet class.
	 * @param species (String)
	 *     This argument represents the species of the pet.
	 * @param age (int)
	 *     This argument represents the age of the pet.
	 * */
	public Pet(String id, String name, String type, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false; //set adopted to false at first because never adopted unless we are aware of it
	}
	
	/*
	 * Method represents the default sort for the class.
	 * */
	@Override
	public int compareTo(Pet pet) {
		return this.name.compareTo(pet.name);
	}


	/* Method gets pet id.*/
	public String getId() {
		return id;
	}

	/* Method sets pet id.*/
	public void setId(String id) {
		this.id = id;
	}

	/* This method prints pet information. */
	@Override
	public String toString() {
		return "Pet Id: " + id + ", Name: " + name + ", Type: " + type + ", Species: " + species + ", Age: " + age
				+ ", Adoption Status: " + adopted;
	}

	/* Method gets pet name. */
	public String getName() {
		return name;
	}

	/* Method sets pet name. */
	public void setName(String name) {
		this.name = name;
	}

	/* Method gets pet type. */
	public String getType() {
		return type;
	}

	/* Method sets pet type. */
	public void setType(String type) {
		this.type = type;
	}

	/* Method gets pet species. */
	public String getSpecies() {
		return species;
	}

	/* Method sets pet species. */
	public void setSpecies(String species) {
		this.species = species;
	}

	/* Method gets pet age. */
	public int getAge() {
		return age;
	}

	/* Method sets pet age. */
	public void setAge(int age) {
		this.age = age;
	}

	/* Method gets pet adoption status. */
	public boolean isAdopted() {
		return adopted;
	}

	/* Method sets pet adoption status. */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	
}

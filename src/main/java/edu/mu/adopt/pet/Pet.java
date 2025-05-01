package edu.mu.adopt.pet;

public abstract class Pet {
	
	int id;
	String name;
	String type;
	String species;
	int age;
	boolean adopted;
	
	public Pet(int id, String name, String type, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false; //set adopted to false at first because never adopted unless we are aware of it
	}

}

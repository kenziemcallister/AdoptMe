package edu.mu.adopt.main;

import edu.mu.adopt.pet.Cat;
import edu.mu.adopt.pet.Dog;
import edu.mu.adopt.pet.Pet;
import edu.mu.adopt.pet.Rabbit;
import edu.mu.adopt.pet.Shelter;

public class Main {

	public static void main(String[] args) {
		
		Shelter<Pet> ourShelter = new Shelter<Pet>();
		Cat kenzie = new Cat(123, "Kenzie", "Cat", "Mancoon", 20);
		Dog kenzie2 = new Dog(1234, "Kenzie2", "Dog", "Golden", 20);
		Rabbit kenzie3 = new Rabbit(12345, "Kenzie3", "Rabbit", "Brown", 20);

		ourShelter.add(kenzie);
		ourShelter.add(kenzie2);
		ourShelter.add(kenzie3);
		System.out.println(ourShelter.toString());
//		
		

	}

}

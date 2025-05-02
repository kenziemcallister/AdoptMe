package edu.mu.adopt.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.mu.adopt.pet.Cat;
import edu.mu.adopt.pet.Dog;
import edu.mu.adopt.pet.ExoticAnimal;
import edu.mu.adopt.pet.ExoticAnimalAdapter;
import edu.mu.adopt.pet.LoadPets;
import edu.mu.adopt.pet.Pet;
import edu.mu.adopt.pet.Rabbit;
import edu.mu.adopt.pet.Shelter;
import edu.mu.adopt.sort.*;

public class Main {

	public static void main(String[] args) {
		
		Shelter<Pet> ourShelter = new Shelter<Pet>();
		Cat gabi = new Cat("123", "Gabi", "Cat", "Mancoon", 30);
		Dog kenzie = new Dog("1234", "Kenzie", "Dog", "Golden", 21);
		Rabbit jessica = new Rabbit("12345", "Jessica", "Rabbit", "Brown", 17);
		
		ExoticAnimal exotic = new ExoticAnimal("123456", "Sophia", "Bird", "Toucan", 29);
		Pet sophia = new ExoticAnimalAdapter(exotic);

		ourShelter.add(gabi);
		ourShelter.add(kenzie);
		ourShelter.add(jessica);
		ourShelter.add(sophia);
//		ourShelter.remove(kenzie2);
//		ourShelter.remove(kenzie6);
		ourShelter.adopt(kenzie);
		System.out.println(ourShelter.getPets());
		
		//Collections.sort(ourShelter.getPets());
		System.out.println(ourShelter.getPets());
		Collections.sort(ourShelter.getPets(), new CompareAge());
		System.out.println(ourShelter.getPets());
		Collections.sort(ourShelter.getPets(), new CompareSpecies());
		System.out.println(ourShelter.getPets());
//		System.out.println(ourShelter.toString());	
		
		//testing the loading from json
		LoadPets loader = new LoadPets();
		
		System.out.println();
		List<Pet> listOfPets = loader.loadPets("src/main/resources/pets.json");
		System.out.println("List of pets from pets.json: ");
		for (int i = 0; i < listOfPets.size(); i++) {
			System.out.println("Pet: " + listOfPets.get(i));
		}
		
		System.out.println();
		List<Pet> listOfExoticPets = loader.loadExoticPets("src/main/resources/exotic_animals.json");
		System.out.println("List of exotic pets from exotic_pets.json: ");
		for (int i = 0; i < listOfExoticPets.size(); i++) {
			System.out.println("Exotic pet: " + listOfExoticPets.get(i));
		}
		

	}

}

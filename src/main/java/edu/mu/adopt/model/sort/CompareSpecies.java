package edu.mu.adopt.model.sort;

import java.util.Comparator;

import edu.mu.adopt.model.pet.Pet;

public class CompareSpecies implements Comparator<Pet>{

	@Override
	public int compare(Pet pet1, Pet pet2) {
		return pet1.getSpecies().compareTo(pet2.getSpecies());
	}

}

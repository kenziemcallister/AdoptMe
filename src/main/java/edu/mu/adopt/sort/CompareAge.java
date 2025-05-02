package edu.mu.adopt.sort;

import java.util.Comparator;

import edu.mu.adopt.pet.Pet;

public class CompareAge implements Comparator <Pet>{

	@Override
	public int compare(Pet pet1, Pet pet2) {
		return pet1.getAge() - pet2.getAge();
	}

}

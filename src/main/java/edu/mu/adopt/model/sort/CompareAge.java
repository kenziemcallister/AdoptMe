package edu.mu.adopt.model.sort;

import java.util.Comparator;

import edu.mu.adopt.model.pet.Pet;

public class CompareAge implements Comparator <Pet>{

	/**
	 * This is a comparator used to compare pets by age.
	 */
	@Override
	public int compare(Pet pet1, Pet pet2) {
		return pet1.getAge() - pet2.getAge();
	}

}

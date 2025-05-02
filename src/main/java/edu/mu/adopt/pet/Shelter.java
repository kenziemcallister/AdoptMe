package edu.mu.adopt.pet;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Pet>{
	
	private List<T> pets;//list of pets within the shelter
	
	public Shelter() {
		this.pets = new ArrayList<T>();
	}

	public void add(T pet) {
		pets.add(pet);
	}
	
	public void remove(T pet) {
		pets.remove(pet);
	}
	
	public void adopt(T pet) {
		if (pet.adopted == true) {
			System.out.println("Pet has already been adopted.");
		} else {
			pet.adopted = true;
		}
	}

	public List<T> getPets() {
		return pets;
	}

	@Override
	public String toString() {
		return "Shelter [pets=" + pets + "]";
	}

}

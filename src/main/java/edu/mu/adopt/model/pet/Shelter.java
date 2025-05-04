package edu.mu.adopt.model.pet;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Shelter <T extends Pet>{
	
	private List<T> pets;//list of pets within the shelter
	
	/**
	 * Default constructor for shelter, instantiates the pet list for the shelter.
	 */
	public Shelter() {
		this.pets = new ArrayList<T>();
	}

	/**
	 * Method to add a pet to the shelter's pet list.
	 * @param pet
	 */
	public void add(T pet) {
		pets.add(pet);
	}
	
	/**
	 * Method to remove a pet to the shelter's pet list.
	 * @param pet
	 */
	public void remove(T pet) {
		pets.remove(pet);
	}
	
	/**
	 * Method to adopt a pet from the shelter's pet list.
	 * @param pet
	 */
	public void adopt(T pet) {
		if (pet.adopted == true) {
			System.out.println("Pet has already been adopted.");
		} else {
			pet.adopted = true;
		}
	}

	/**
	 * Getter to get the list of pets from the shelter.
	 * @return
	 */
	public List<T> getPets() {
		return pets;
	}

	/**
	 * This is a to string for the shelter's pet list.
	 */
	@Override
	public String toString() {
		return "Shelter [pets=" + pets + "]";
	}
	
	/**
	 * This is a method used to save the pet list to a
	 * JSON file in the src/main/resources folder with 
	 * the time stamp as the name.
	 */
	public void savePets() {
		
		String timestamp = new SimpleDateFormat("YYYYMMDD_HHMMSS").format(new Date()); //get current date time
		
		System.out.println("Saving list to json file...");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter fileWriter = new FileWriter("src/main/resources/"+ timestamp + "_pets.json")) { //saving with correct format
			
			gson.toJson(pets, fileWriter); //save to the right location
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("List saved successfully!");
	}

}

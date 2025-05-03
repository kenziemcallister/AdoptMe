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
	
	//method to save a list to a json file
	public void savePets() {
		
		String timestamp = new SimpleDateFormat("YYYYMMDD_HHMMSS").format(new Date());
		
		System.out.println("Saving list to json file...");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter fileWriter = new FileWriter("src/main/resources/"+ timestamp + "_pets.json")) {
			
			gson.toJson(pets, fileWriter);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("List saved successfully!");
	}

}

package edu.mu.adopt.model.pet;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LoadPets {
	
	/**
	 * This method is used to load a list of pets from a JSON file.
	 * @param filepath
	 * 		The file path to where the JSON file is located to read it.
	 * @return
	 * 		Returns a list of pets that was extracted from the JSON file.
	 */
	public List<Pet> loadPets(String filepath) {
		
		List<Pet> petList = new ArrayList<>(); //new list that will be returned
		
		try (FileReader reader = new FileReader(filepath)) { //getting a reader to read the file
			
			JsonArray fileArray = JsonParser.parseReader(reader).getAsJsonArray();
			for (int i = 0; i < fileArray.size(); i++) { //for each object in the fileArray
				
				JsonObject obj = fileArray.get(i).getAsJsonObject();
				
				String id = obj.get("id").getAsString(); //get fields for pet
				String name = obj.get("name").getAsString();
				String type = obj.get("type").getAsString();
				String species = obj.get("species").getAsString();
				int age = obj.get("age").getAsInt();
				
				//figuring out type of pet so we can instantiate it and add to list
				if (type.equals("Dog")) {
					petList.add(new Dog(id, name, type, species, age));
				} else if (type.equals("Cat")) {
					petList.add(new Cat(id, name, type, species, age));
				} else if (type.equals("Rabbit")) {
					petList.add(new Rabbit(id, name, type, species, age));
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return petList;
		
	}
	
	/**
	 * This method is used to load a JSON file of exotic animals
	 * into a list.
	 * @param filepath
	 * 		This is the file path where the JSON file is located.
	 * @return
	 * 		Returns a list of exotic animals from the JSON file.
	 */
	public List<Pet> loadExoticPets(String filepath) {
		
		List<Pet> wrappedPetList = new ArrayList<>();
		
		try (FileReader reader = new FileReader(filepath)) {
			
			JsonArray fileArray = JsonParser.parseReader(reader).getAsJsonArray();
			for (int i = 0; i < fileArray.size(); i++) { //for each object in the file
				
				//wrap the exotic pets to pet list
				JsonObject obj = fileArray.get(i).getAsJsonObject();
	            
	            String uniqueId = obj.get("uniqueId").getAsString();
	            String animalName = obj.get("animalName").getAsString();
	            String category = obj.get("category").getAsString();
	            String subSpecies = obj.get("subSpecies").getAsString();
	            int yearsOld = obj.get("yearsOld").getAsInt();
	            
	            ExoticAnimal exotic = new ExoticAnimal(uniqueId, animalName, category, subSpecies, yearsOld); //get the new exotic animal
	            
	            ExoticAnimalAdapter wrappedPet = new ExoticAnimalAdapter(exotic); //wrap it as a pet
	            wrappedPetList.add(wrappedPet); //add the wrapped pet to the pet list to return
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wrappedPetList;
		
	}

}
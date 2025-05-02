package edu.mu.adopt.pet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LoadPets {
	
	//need method to load pets from json file
	public List<Pet> loadPets(String filepath) {
		
		List<Pet> petList = new ArrayList<>();
		Gson gson = new Gson();
		
		try (FileReader reader = new FileReader(filepath)) {
			
			JsonArray fileArray = JsonParser.parseReader(reader).getAsJsonArray();
			for (int i = 0; i < fileArray.size(); i++) {
				
				JsonObject obj = fileArray.get(i).getAsJsonObject();
				
				String id = obj.get("id").getAsString();
				String name = obj.get("name").getAsString();
				String type = obj.get("type").getAsString();
				String species = obj.get("species").getAsString();
				int age = obj.get("age").getAsInt();
				boolean adopted = obj.get("adopted").getAsBoolean();
				
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
	
	//method to load the exotic pets
	public List<Pet> loadExoticPets(String filepath) {
		
		List<Pet> wrappedPetList = new ArrayList<>();
		Gson gson = new Gson();
		
		try (FileReader reader = new FileReader(filepath)) {
			
			JsonArray fileArray = JsonParser.parseReader(reader).getAsJsonArray();
			for (int i = 0; i < fileArray.size(); i++) {
				
				//wrap the exotic pets to pet list
				JsonObject obj = fileArray.get(i).getAsJsonObject();
	            
	            String uniqueId = obj.get("uniqueId").getAsString();
	            String animalName = obj.get("animalName").getAsString();
	            String category = obj.get("category").getAsString();
	            String subSpecies = obj.get("subSpecies").getAsString();
	            int yearsOld = obj.get("yearsOld").getAsInt();
	            
	            ExoticAnimal exotic = new ExoticAnimal(uniqueId, animalName, category, subSpecies, yearsOld);
	            
	            ExoticAnimalAdapter wrappedPet = new ExoticAnimalAdapter(exotic);
	            wrappedPetList.add(wrappedPet);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wrappedPetList;
		
	}
	
	
	//method to save a list to a json file
	public void savePets(List<Pet> petList) {
		
		System.out.println("Saving list to json file...");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter fileWriter = new FileWriter("src/main/resources/date_time_here.json")) {
			
			gson.toJson(petList, fileWriter);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("List saved successfully!");
	}

}
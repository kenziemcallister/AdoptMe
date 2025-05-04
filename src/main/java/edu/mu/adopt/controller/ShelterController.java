package edu.mu.adopt.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import edu.mu.adopt.model.pet.*;
import edu.mu.adopt.model.pet.Pet;
import edu.mu.adopt.model.pet.ShelterManager;
import edu.mu.adopt.model.sort.CompareAge;
import edu.mu.adopt.model.sort.CompareSpecies;
import edu.mu.adopt.view.ShelterView;

public class ShelterController {

	private ShelterManager shelterManager;
	private ShelterView shelterView;
	
	/**
	 * This is the default constructor for the shelter controller.
	 * It instantiates the shelter manager for singleton and the shelter view.
	 */
	public ShelterController() {
		this.shelterManager = new ShelterManager();;
		this.shelterView = new ShelterView(this.shelterManager, this);
	}
	
	/**
	 * This method starts up the shelterView.
	 */
	public void initiate() {
		shelterView.setVisible(true);
	}
	
	/**
	 * This method adds a new pet to the passed in pet List.
	 * @param pets - the pet list to be added to.
	 * @param newPet - the pet to be added to the list.
	 */
	public void addPet(List<Pet> pets, Pet newPet) {
		
		for(Pet pet: pets) { //for each pet in list
			if(pet.getId().compareTo(newPet.getId()) == 0) { //if the id is in use, show the error message
				JOptionPane.showMessageDialog(null, "Pet ID Already In Use", "Add To Shelter", JOptionPane.PLAIN_MESSAGE); 
				return;
			}
		}
		
		shelterManager.getShelter().add(newPet); //add the new pet to the list through shelter manager
		String addMsg = newPet.getName() + " Added to Shelter";
		
		JOptionPane.showMessageDialog(null, addMsg, "Add To Shelter", JOptionPane.PLAIN_MESSAGE); //show success
	}
	
	/**
	 * This method is used to adopt the selected pets from the view.
	 * @param pets - the list of selected pets by the user.
	 */
	public void adoptSelectedPets(List<Pet> pets) {
		for (Pet pet : pets) {
		    StringBuilder alreadyAdopted = new StringBuilder(); //getting string to use for warning message
			
			if (pet.isAdopted() == true) {
	            alreadyAdopted.append(pet.getName()).append(" is already adopted.");
			} else {
				shelterManager.getShelter().adopt(pet);
			}
			
			if (alreadyAdopted.length() > 0) {
		        JOptionPane.showMessageDialog(null, alreadyAdopted.toString(), "Already Adopted", JOptionPane.WARNING_MESSAGE);
		    }
			
		}
	}
	
	/**
	 * This method is used to remove the selected pets from the view.
	 * @param pets - the list of selected pets to remove.
	 */
	public void removeSelectedPets(List<Pet> pets) {
		
		for (Pet pet : pets) {
			shelterManager.getShelter().remove(pet);
		}
		
	}
	
	/**
	 * This method is used to view the selected pets on a dialog.
	 * @param pets - a list of selected pets to display.
	 */
	public void viewSelectedPets(List<Pet> pets) {
		for (Pet pet: pets) {
			JOptionPane.showMessageDialog(null, pet.toString(), "View Pet Information", JOptionPane.PLAIN_MESSAGE); //show pets in dialog
		}
	}
	
	/**
	 * This method is used to save the pet list to a new json file to the resources folder.
	 */
	public void savePetList() {
		
		String savedSuccess = "List was successfully saved to resources folder.";
		shelterManager.getShelter().savePets();
		JOptionPane.showMessageDialog(null, savedSuccess, "Save Successful", JOptionPane.PLAIN_MESSAGE); //adding pop up window
		
	}
	
	/**
	 * This method is used to sort the list of pets by a given field.
	 * @param selection - field used to sortBy
	 * @return - returns the list of pets after it is sorted.
	 */
	public List<Pet> sortPets(String selection) {
		
		List<Pet> pets = shelterManager.getShelter().getPets();
		//System.out.println(pets);
		switch (selection) { //determining which field to sortBy based on combobox selection that was passed in
			case "Name":
				Collections.sort(pets);
				break;
			case "Age":
				Collections.sort(pets, new CompareAge());
				break;
			case "Species":
				Collections.sort(pets, new CompareSpecies());
				break;
		}
		return pets;
		
	}
	
}

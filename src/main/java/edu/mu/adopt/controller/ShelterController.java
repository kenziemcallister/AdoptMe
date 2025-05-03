package edu.mu.adopt.controller;

import java.util.List;

import javax.swing.JOptionPane;

import edu.mu.adopt.model.pet.Pet;
import edu.mu.adopt.model.pet.ShelterManager;
import edu.mu.adopt.view.ShelterView;

public class ShelterController {

	private ShelterManager shelterManager;
	private ShelterView shelterView;
	
	public ShelterController() {
		this.shelterManager = new ShelterManager();;
		this.shelterView = new ShelterView(this.shelterManager, this);
	}
	
	public void initiate() {
		shelterView.setVisible(true);
	}
	
	//action for adopt button to adopt pet
	public void adoptSelectedPets(List<Pet> pets) {
		for (Pet pet : pets) {
		    StringBuilder alreadyAdopted = new StringBuilder();
			
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
	
	//action for remove button to remove a pet
	
}

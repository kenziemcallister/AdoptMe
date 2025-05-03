package edu.mu.adopt.controller;

import edu.mu.adopt.model.pet.ShelterManager;
import edu.mu.adopt.view.ShelterView;

public class ShelterController {

	private ShelterManager shelterManager;
	private ShelterView shelterView;
	
	public ShelterController() {
		this.shelterManager = new ShelterManager();;
		this.shelterView = new ShelterView(this.shelterManager);
	}
	
	public void initiate() {
		shelterView.setVisible(true);
	}
	
}

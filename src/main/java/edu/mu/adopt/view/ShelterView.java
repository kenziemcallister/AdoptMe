package edu.mu.adopt.view;
import edu.mu.adopt.model.sort.CompareAge;
import edu.mu.adopt.model.sort.CompareSpecies;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.mu.adopt.controller.ShelterController;
import edu.mu.adopt.model.pet.Pet;
import edu.mu.adopt.model.pet.Shelter;
import edu.mu.adopt.model.pet.ShelterManager;

import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShelterView extends JFrame {

	private JPanel panel;
	private ShelterManager manager;
	private ShelterController controller;
	
	public ShelterView(ShelterManager manager, ShelterController controller) {
		
		this.manager = manager;
		this.controller = controller;
		
		setTitle("Lakewood Shelter Adoption");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 24, 623, 188);
		panel.add(scrollPane);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>(); 
		
		for(Pet pet : manager.getShelter().getPets())
		{
			modelList.addElement(pet);
		}
		
		JList<Pet> list = new JList<Pet>(modelList);
		scrollPane.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		
		JButton addButton = new JButton("ADD");
		addButton.setBounds(38, 224, 89, 29);
		panel.add(addButton);
		
		//adopt button
		JButton adoptButton = new JButton("ADOPT");
		adoptButton.setBounds(139, 224, 89, 29);
		panel.add(adoptButton);
		
		//adopt button action using shelter controller
		adoptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Pet> selectedPets = list.getSelectedValuesList();
				controller.adoptSelectedPets(selectedPets);
				list.repaint(); //show changes
			}
		});
		
		//remove button
		JButton removeButton = new JButton("REMOVE");
		removeButton.setBounds(240, 224, 103, 29);
		panel.add(removeButton);
		
		//remove button action using controller
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Pet> selectedPets = list.getSelectedValuesList();
				controller.removeSelectedPets(selectedPets); //update models
				
				for (Pet pet : selectedPets) {
					modelList.removeElement(pet); //update gui
				}
			}
		});
		
		JButton viewButton = new JButton("VIEW");
		viewButton.setBounds(355, 224, 89, 29);
		panel.add(viewButton);
		
		//save button
		JButton saveButton = new JButton("SAVE");
		saveButton.setBounds(456, 224, 89, 29);
		panel.add(saveButton);
		
		//save button action using controller
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.savePetList(); //saving pet list to resources through the controller
			}
		});
		
		//combo box for sorting
		String[] sortOptions = {"Name", "Age", "Species"};
		JComboBox<String> comboBox = new JComboBox<>(sortOptions);
		comboBox.setBounds(38, 279, 89, 22);
		panel.add(comboBox);
				
		//action for combo box
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String selection = (String) comboBox.getSelectedItem();
				List<Pet> sortedPetList = controller.sortPets(selection);
				
				modelList.clear();
				System.out.println(modelList);
				for (Pet pet : sortedPetList) {
					modelList.addElement(pet);
				}
			}
			
		});
		
	}
	
}

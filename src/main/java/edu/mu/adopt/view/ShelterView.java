package edu.mu.adopt.view;
import edu.mu.adopt.model.sort.CompareAge;
import edu.mu.adopt.model.sort.CompareSpecies;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.mu.adopt.controller.ShelterController;
import edu.mu.adopt.model.pet.ExoticAnimal;
import edu.mu.adopt.model.pet.ExoticAnimalAdapter;
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
import javax.swing.JTextArea;
import java.awt.Color;

public class ShelterView extends JFrame {

	private JPanel panel;
	private ShelterManager manager;
	private ShelterController controller;
	private JTextField idField;
	private JTextField nameField;
	private JTextField typeField;
	private JTextField speciesField;
	private JTextField ageField;
	
	public ShelterView(ShelterManager manager, ShelterController controller) {
		
		this.manager = manager;
		this.controller = controller;
		
		setTitle("Lakewood Shelter Adoption");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		
		panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
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
		
		JButton addButton = new JButton("ADD PET");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExoticAnimal newPetType = new ExoticAnimal(getIdField(), getNameField(), getTypeField(),
						getSpeciesField(), getAgeField());
				Pet newPet = new ExoticAnimalAdapter(newPetType);
				
				controller.addPet(manager.getShelter().getPets(), newPet);
				
				boolean idExists = false;
				
				for(Pet pet: manager.getShelter().getPets()) {
					if(pet.getId().compareTo(newPet.getId()) == 0) {
						idExists = true;
					}
				}
				
				if(idExists == true)
				{
					modelList.addElement(newPet);
				}
			}
		});
		addButton.setBounds(126, 448, 130, 29);
		panel.add(addButton);
		
		//adopt button
		JButton adoptButton = new JButton("ADOPT");
		adoptButton.setBounds(207, 224, 89, 29);
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
		removeButton.setBounds(308, 224, 103, 29);
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
		viewButton.setBounds(423, 224, 89, 29);
		panel.add(viewButton);
		
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Pet> selectedPets = list.getSelectedValuesList();
				controller.viewSelectedPets(selectedPets);
			}
		});
		
		//save button
		JButton saveButton = new JButton("SAVE");
		saveButton.setBounds(524, 224, 89, 29);
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
		comboBox.setBounds(106, 227, 89, 22);
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
		
		JTextArea txtrSort = new JTextArea();
		txtrSort.setBackground(new Color(238, 238, 238));
		txtrSort.setText("SORT BY:");
		txtrSort.setBounds(48, 229, 56, 22);
		panel.add(txtrSort);
		
		idField = new JTextField();
		idField.setBounds(126, 264, 130, 26);
		panel.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(126, 302, 130, 26);
		panel.add(nameField);
		nameField.setColumns(10);
		
		typeField = new JTextField();
		typeField.setBounds(126, 340, 130, 26);
		panel.add(typeField);
		typeField.setColumns(10);
		
		speciesField = new JTextField();
		speciesField.setBounds(126, 378, 130, 26);
		panel.add(speciesField);
		speciesField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setBounds(126, 416, 130, 26);
		panel.add(ageField);
		ageField.setColumns(10);
		
		JTextArea txtrPetId = new JTextArea();
		txtrPetId.setBackground(new Color(238, 238, 238));
		txtrPetId.setText("PET ID:");
		txtrPetId.setBounds(38, 269, 76, 16);
		panel.add(txtrPetId);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setBackground(new Color(238, 238, 238));
		txtrName.setText("NAME:");
		txtrName.setBounds(38, 307, 76, 16);
		panel.add(txtrName);
		
		JTextArea txtrType = new JTextArea();
		txtrType.setBackground(new Color(238, 238, 238));
		txtrType.setText("TYPE:");
		txtrType.setBounds(38, 345, 76, 16);
		panel.add(txtrType);
		
		JTextArea txtrSpecies = new JTextArea();
		txtrSpecies.setBackground(new Color(238, 238, 238));
		txtrSpecies.setText("SPECIES:");
		txtrSpecies.setBounds(38, 383, 76, 16);
		panel.add(txtrSpecies);
		
		JTextArea txtrAge = new JTextArea();
		txtrAge.setBackground(new Color(238, 238, 238));
		txtrAge.setText("AGE:");
		txtrAge.setBounds(38, 421, 76, 16);
		panel.add(txtrAge);
				
		
	}
	
	public String getIdField() {
		return idField.getText();
	}
	
	public String getNameField() {
		return nameField.getText();
	}
	
	public String getTypeField() {
		return typeField.getText();
	}
	
	public String getSpeciesField() {
		return speciesField.getText();
	}
	
	public Integer getAgeField() {
		int age = -1;
		
		try {
			age = Integer.parseInt(ageField.getText());
		} catch (Exception e) {
			return 1;
		}
		return age;
	}
}

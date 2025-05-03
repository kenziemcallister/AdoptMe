package edu.mu.adopt.view;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.mu.adopt.model.pet.Pet;
import edu.mu.adopt.model.pet.Shelter;
import edu.mu.adopt.model.pet.ShelterManager;

import javax.swing.JList;
import java.awt.BorderLayout;

public class ShelterView extends JFrame {

	private JPanel panel;
	private JList list;
	private ShelterManager manager;
	
	public ShelterView(ShelterManager manager) {
		
		setTitle("Lakewood Shelter Adoption");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>(); 
		
		for(Pet pet : manager.getShelter().getPets())
		{
			modelList.addElement(pet);
		}
		
		list = new JList<Pet>(modelList);
		list.setBounds(44, 28, 601, 217);
		panel.add(list);
	}	
}

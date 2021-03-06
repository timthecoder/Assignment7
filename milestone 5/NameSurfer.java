/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	private NameSurferDataBase namesDB = new NameSurferDataBase("names-data.txt");
	private NameSurferGraph graph;
	
	private JLabel nameLabel = new JLabel("Name: ");
	private JTextField nameField = new JTextField(30);
	private JButton graphButton = new JButton("Graph");
	private JButton clearButton = new JButton("Clear");
	
	
	
	public void init() {

		
		//create the JTextfield initializers
		add(nameLabel,NORTH);
		add(nameField,NORTH);
		add(graphButton, NORTH);
		add(clearButton, NORTH);
		
		
		
		//Here I trigger the ability to implement actions for the Interactor
		addActionListeners();
		nameField.addActionListener(this);
	}
	
	public void run(){
		
		graph = new NameSurferGraph();
		add(graph);
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Here are the implementations of all the actions of each Interactors
		
		if( e.getSource() == graphButton){
			graph.addEntry(namesDB.findEntry(nameField.getText()));
			graph.update();
		}else if( e.getSource() == clearButton){
			graph.clear();
			graph.update();
		}else if( e.getSource() == nameField ){
			graph.addEntry(namesDB.findEntry(nameField.getText()));
			graph.update();
		}
		
	}
}

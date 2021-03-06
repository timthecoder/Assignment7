/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	
	
	public NameSurferGraph() {
		addComponentListener(this);
		
	}
	
	
	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		removeAll();
	}
	
	
	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
	}
	
	
	/**
	 * Updates the display image by deleting all the graphical objects
	 * from the canvas and then reassembling the display according to
	 * the list of entries. Your application must call update after
	 * calling either clear or addEntry; update is also called whenever
	 * the size of the canvas changes.
	 */
	public void update() {
		clear();
		drawChart();
		drawLabels();
	}
	
	private void drawChart(){
		double xSpacing = getWidth()/12;
		
		
		
		for(int i = 0; i < NDECADES; i++){
			GLine line = new GLine(xSpacing * i ,0,xSpacing * i ,getHeight());
			add(line);
		}
		GLine line = new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
		add(line);
		GLine line2 = new GLine(0,getHeight() -GRAPH_MARGIN_SIZE,getWidth(), getHeight() - GRAPH_MARGIN_SIZE);
		add(line2);
	}
	
	private void drawLabels(){
		double xSpacing = getWidth()/12;
		int date = 1900;
		
		for( int i = 0; i < NDECADES; i++){
			
			String dateString = Integer.toString(date);
			GLabel label = new GLabel(dateString,xSpacing * i,getHeight());
			label.setFont("Courier-20");
			add(label);
			date += 10;
		}
		
		
	}
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}

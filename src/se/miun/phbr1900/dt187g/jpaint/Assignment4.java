package se.miun.phbr1900.dt187g.jpaint;

import javax.swing.SwingUtilities;

/**
* <h1>Assignment 4</h1>
* This class is the starting point for the JPaint drawing application.
* It creates a JFrame and makes it visible.
* 
* @author  phbr1900
* @version 1.0
*/
public class Assignment4 {

	public static void main(String[] args) {
		// Always make sure GUI is created on the event dispatching thread.
		// This will be explained in Java III (the lesson about threads).
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JPaintFrame().setVisible(true);
			}
		});		
	}
}
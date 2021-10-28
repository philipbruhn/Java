package se.miun.phbr1900.dt187g.jpaint;

import javax.swing.SwingUtilities;

/**
* <h1>Assignment 8</h1>
* This class is the starting point for the drawing application.
* It creates a JFrame and makes it visible.
* 
* @author  Your Name (your student id)
* @version 1.0
*/
public class Assignment8 {

	public static void main(String[] args) {
		// Make sure GUI is created on the event dispatching thread
		// This will be explained in Java III (the lesson about threads)
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JPaintFrame().setVisible(true);
			}
		});		
	}
}
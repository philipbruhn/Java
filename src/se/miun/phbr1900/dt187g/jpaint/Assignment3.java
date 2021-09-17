package se.miun.phbr1900.dt187g.jpaint;

/**
* <h1>Assignment 3</h1>
* This application creates a <code>Drawing</code> and saves it with
* or without information on author and/or name. Try-catch is implemented
* to catch any <code>DrawingException</code>s that are thrown when saving. 
* <p>
* Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
* 
*
* @author  phbr1900
* @version 1.0
*/
public class Assignment3 {
	private static final String FILENAME = "test.drawing";

	public static void main(String[] args) {
		testDrawing();
	}

	private static void testDrawing() {
		// Create an empty drawing and save it
		System.out.println("Creating and saving an empty drawing...");
		Drawing monaLisa = new Drawing();
		testSaveDrawing(monaLisa);
		
		// Set name and save
		System.out.println("\nSetting only name and then save...");
		monaLisa.setName("Mona Lisa");
		monaLisa.setAuthor(null); // null will throw a DrawingException
		testSaveDrawing(monaLisa);
		
		// Set author and save
		System.out.println("\nSetting only author and then save...");
		monaLisa.setName(""); // Zero length name will throw a DrawingException
		monaLisa.setAuthor("L. da Vincis");
		testSaveDrawing(monaLisa);
		
		// Set author and save
		System.out.println("\nSetting name and author and then save...");
		monaLisa.setName("Mona Lisa");
		monaLisa.setAuthor("L. da Vincis");
		testSaveDrawing(monaLisa);
	}
	
	private static void testSaveDrawing(Drawing drawingToSave) {
		
		boolean saved = false;
		try{
			saved = drawingToSave.save(FILENAME);
		}
		catch(DrawingException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("The drawing was" + (saved ? "" :  " not") + " saved");
		}
		
	}
}
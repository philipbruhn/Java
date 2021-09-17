package se.miun.phbr1900.dt187g.jpaint;

/**
* <h1>DrawingException</h1>
*  Throws drawing exceptions if the drawing does not contain ifnormation about the author, name or both. 
* 
*
* @author  phbr1900
* @version 1.0
*/

public class DrawingException extends Exception {
    public DrawingException(String message) {
        super(message);
    }
}

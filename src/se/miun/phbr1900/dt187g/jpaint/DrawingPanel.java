package se.miun.phbr1900.dt187g.jpaint;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
* <h1>Drawing Panel</h1>
* Inherits fron JPanel. Is the custom class for the drawing area in JPaint.
* Contains metods to handle drawings and draw them out. Has a fixed background. 
* 
* @author Your Name (your student id)
* @version 1.0
*/

public class DrawingPanel extends JPanel {
    
    private Drawing drawing;

    public DrawingPanel() {
        this(new Drawing());
        
    }

    public DrawingPanel(Drawing drawing) {
        super();
        this.drawing = drawing;
        setBackground(null);
        this.repaint();
    }

    public Drawing getDrawing(){
        return drawing;
    }

    public void setDrawing(Drawing drawing){
        this.drawing = drawing;
        repaint();
    }

    public void addShapesFromDrawing(Drawing drawing){
        this.drawing.shapes.addAll(drawing.shapes);
        repaint();
    }

    public void removeLastShapeFromList(){
        if (drawing.shapes.size() > 0){
            drawing.shapes.remove(drawing.shapes.size()-1);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (drawing == null){
            return;
        }
        else{
            drawing.draw(g);
            repaint();
        }
        
        
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.WHITE);
    }
    
}

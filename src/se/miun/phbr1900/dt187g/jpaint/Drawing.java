package se.miun.phbr1900.dt187g.jpaint;

import java.awt.Graphics;
import java.util.ArrayList;

/**
* <h1>Drawing</h1>
* Class for Drawing, implements Drawable. 
* Contains properties for name of the drawing, name of the author, and a list of shapes that together makes the drawing.  
* Has methods for getting and setting name and author, aswell as the amout of shapes, total circumference and total area.  
*
* @author phbr1900
* @version 1.1
*/



public class Drawing implements Drawable {
    public Drawing() {

    }

    public Drawing(String name, String author) {
        this.name = name;
        this.author = author;
    }

    private String name = "";
    private String author = "";
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void addShape(Shape shape){
        if (shape != null){
            shapes.add(shape);
        }
    }

    public int getSize(){
        return shapes.size();
    }

    public double getTotalCircumference(){
        double totalCircumference = 0;
        for(Shape shape : shapes){
            double shapeCircumference = shape.getCircumference();
            if(shapeCircumference > -1){
                totalCircumference += shapeCircumference;
            }
        }
        return totalCircumference;
    }

    public double getTotalArea(){
        double totalArea = 0;
        for(Shape shape : shapes){
            double shapeArea = shape.getArea();
            if(shapeArea > -1){
                totalArea += shapeArea;
            }
        }
        return totalArea;
    }

    @Override
    public void draw() {
        String print = "A drawing by " + author + " called " + name;
        for(Shape shape : shapes){
            print += "\n" + shape;
        }
        System.out.println(print);
        
    }

    @Override
    public void draw(Graphics g) {
        
    }

    public boolean save(String filename) throws DrawingException{
        if((author == null || author.length() == 0 ) && (name == null || name.length() == 0 )){
            throw new DrawingException("The drawing is missing author and name");
        }
        if(author == null || author.length() == 0 ){
            throw new DrawingException("The drawing is missing author");
        }
        if(name == null || name.length() == 0 ){
            throw new DrawingException("The drawing is missing name");
        }
        return true;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+"[name=" + name + "; author=" + author + "; size=" + getSize() + "; circumference=" + getTotalCircumference() + "; area=" + getTotalArea() + "]";
    }
    
}

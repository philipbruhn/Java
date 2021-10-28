package se.miun.phbr1900.dt187g.jpaint;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

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
    protected ArrayList<Shape> shapes = new ArrayList<Shape>();

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

    public void addPointToLatestShape(Point point){
        if (shapes != null || shapes.size() == 0){
            shapes.get(shapes.size()-1).addPoint(point);
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
        for (var shape : shapes){
            if (shape.hasEndpoint()){
                shape.draw(g);
            }
        }
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
        if (!filename.endsWith(".shape")){
            filename += ".shape";
        }
        try{
            Path path = Path.of("SavedPictures" ,filename);
            List<String> lines = new ArrayList<String>();
            lines.add(name);
            lines.add(author);
            for (var shape :shapes ){
                String line = shape.getClass().getSimpleName().toLowerCase() + "," + shape.getPoint(0) + "," + shape.getPoint(1) + "," + shape.getColor();
                lines.add(line.replace(" ", ""));
            }
            Files.write(path, lines);
            return true;
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean load(String filename){
        Path file = Path.of(filename);
        try{
            List<String> lines = Files.readAllLines(file);
            name = lines.get(0);
            author = lines.get(1);
            for(int i = 2; i < lines.size(); i++){
                if (!lines.get(i).isBlank()){
                    String[] param = lines.get(i).split(",");
                    Shape shape = null;
                    Point p1 = new Point(Double.parseDouble(param[1]),Double.parseDouble(param[2]));
                    Point p2 = new Point(Double.parseDouble(param[3]),Double.parseDouble(param[4]));
                    if (param[0].equals("rectangle")){
                        shape = new Rectangle(p1,param[5]);
                    }
                    if (param[0].equals("circle")){
                        shape = new Circle(p1,param[5]);
                    }
                    shape.addPoint(p2);
                    addShape(shape);
                }
            }
            return true;
        }
        catch (IOException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()+"[name=" + name + "; author=" + author + "; size=" + getSize() + "; circumference=" + getTotalCircumference() + "; area=" + getTotalArea() + "]";
    }
    
}

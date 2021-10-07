package se.miun.phbr1900.dt187g.jpaint;

import java.util.ArrayList;

/**
* Shape
*
* Abstract base class for different shapes. Holds points and has methods that are the same for all shapes like addPoint.  
*
* @author phbr1900
* @version 1.1
*/

public abstract class Shape implements Drawable {

    public Shape(double x, double y, String color) {
       this(new Point(x, y), color);
    }

    public Shape(Point p, String color) {
        points = new ArrayList<Point>(2);
        points.add(p);
        this.color = color;
    }

    protected String color;
    protected ArrayList<Point> points;

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public abstract boolean hasEndpoint();

    public abstract double getCircumference();

    public abstract double getArea();

    public void addPoint(Point point){
        if(hasEndpoint()){
            points.set(1, point);

        }
        else{
            points.add(point);
        }
    }
    public void addPoint(double x, double y){
        addPoint(new Point(x,y));
    }
}

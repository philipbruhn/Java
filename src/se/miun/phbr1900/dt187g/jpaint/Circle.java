package se.miun.phbr1900.dt187g.jpaint;

/**
* Cricle
*
* Inherits from Shape. Adds methods for calcutating radius, area and circumference on a circle.  
*
* @author phbr1900
* @version 1.0
*/

import java.awt.Graphics;

public class Circle extends Shape {
    public Circle(double x, double y, String color) {
        super(x,y,color);
    }
    public Circle(Point p, String color) {
        super(p, color);
    }
    
    private double pi = 3.14;

    public boolean hasEndpoint(){
        if(points.size() < 2){
            return false;
        }
        else {
            return true;
        }
    }

    public double getRadius(){
        if(hasEndpoint()){
            double a = points.get(0).getX() - points.get(1).getX();
            double b = points.get(0).getY() - points.get(1).getY();
            return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        }
        return -1;
    }

    @Override
    public void draw() {
        System.out.println(toString());
    }
    @Override
    public void draw(Graphics g) {
        
    }
    @Override
    public double getCircumference() {
        if(hasEndpoint()){
            return pi * 2 * getRadius(); 
        }
        return -1;
    }
    @Override
    public double getArea() {
        if(hasEndpoint()){
            return pi * Math.pow(getRadius(), 2);
        }
        return -1;
    }
    @Override
    public String toString(){
        if(hasEndpoint()){
            return this.getClass().getSimpleName()+"[start=" + points.get(0) + "; end=" + points.get(1) + "; radius=" + getRadius() + "; color=" + color + "]";
        }
        return this.getClass().getSimpleName()+"[start=" + points.get(0) + "; end=N/A; radius=N/A; color=" + color + "]";
    }
}

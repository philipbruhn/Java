package se.miun.phbr1900.dt187g.jpaint;

/**
* Rectangle
*
* Inherits from Shape. Adds methods for calcutating width, height, area and circumference on a rectangle.  
*
* @author phbr1900
* @version 1.0
*/

import java.awt.Graphics;

public class Rectangle extends Shape {
    public Rectangle(double x, double y, String color) {
        super(x, y, color);
    }
    public Rectangle(Point p, String color) {
        super(p, color);
    }

    @Override
    public boolean hasEndpoint(){
        if(points.size() < 2){
            return false;
        }
        else {
            return true;
        }
    }

    public double getWidth(){
        if(hasEndpoint()){
            return Math.abs(points.get(0).getX() - points.get(1).getX());
        }
        return -1;
    }

    public double getHeight(){
        if(hasEndpoint()){
            return Math.abs(points.get(0).getY() - points.get(1).getY());
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
            return getWidth() * 2 + getHeight() *2;
        }
        return -1;
    }
    @Override
    public double getArea() {
        if(hasEndpoint()){
            return getWidth() * getHeight();
        }
        return -1;
    }
    @Override
    public String toString(){
        if(hasEndpoint()){
            return this.getClass().getSimpleName()+"[start=" + points.get(0) + "; end=" + points.get(1) + "; width=" + getWidth() + "; height=" + getHeight() + "; color=" + color + "]";
        }
        return this.getClass().getSimpleName()+"[start=" + points.get(0) + "; end=N/A; width=N/A; height=N/A; color=" + color + "]";

    }
}

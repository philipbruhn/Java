package se.miun.phbr1900.dt187g.jpaint;

import java.awt.Graphics;

public class Circle extends Shape {
    public Circle(double x, double y, String color) {
        super(x,y,color);
    }
    public Circle(Point p, String color) {
        super(p, color);
    }
    
    private double pi = 3.14;

    public double getRadius(){
        if(points[1] != null){
            double a = points[0].getX() - points[1].getX();
            double b = points[0].getY() - points[1].getY();
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
        if(points[1] != null){
            return pi * 2 * getRadius(); 
        }
        return -1;
    }
    @Override
    public double getArea() {
        if(points[1] != null){
            return pi * Math.pow(getRadius(), 2);
        }
        return -1;
    }
    @Override
    public String toString(){
        if(points[1] != null){
            return "Circle[start=" + points[0] + "; end=" + points[1] + "; radius=" + getRadius() + "color=" + color + "]";
        }
        return "Circle[start=" + points[0] + "; end=N/A; radius=N/A; color=" + color + "]";
    }
}

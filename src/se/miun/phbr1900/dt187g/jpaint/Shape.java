package se.miun.phbr1900.dt187g.jpaint;

public abstract class Shape implements Drawable {

    public Shape(double x, double y, String color) {
        points = new Point[2];
        points[0] = new Point(x,y);
        this.color = color;
    }
    public Shape(Point p, String color) {
        points = new Point[2];
        points[0] = p;
        this.color = color;
    }

    protected String color;
    protected Point[] points;

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public abstract double getCircumference();

    public abstract double getArea();

    public void addPoint(Point point){
        points[1] = point;
    }
    public void addPoint(double x, double y){
        points[1] = new Point(x,y);
    }
}

package se.miun.phbr1900.dt187g.jpaint;

public class Point {
    public Point() {
        x = 0.0;
        y = 0.0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    private double x;
    private double y;

    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }

    @Override
    public String toString(){
        return   x + ", " + y;
    }
}

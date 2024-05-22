/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle implements Shape {
    // instance variables - replace the example below with your own
    private Point center;
    private double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle(double radius) {
        /** this.center = center; */
        this.radius = radius;
    }

    public double computeArea() {
        return Math.PI * radius * radius;
    }
    
    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }
    
}

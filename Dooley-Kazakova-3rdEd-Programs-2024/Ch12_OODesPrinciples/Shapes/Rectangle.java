/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle implements Shape {
    private double width;
    private double height;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double computeArea() {
        return width * height;
    }
    
    public double computePerimeter() {
        return (2 * width) + (2 * height);
    }
}

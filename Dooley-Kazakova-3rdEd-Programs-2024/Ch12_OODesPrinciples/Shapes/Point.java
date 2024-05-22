/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor for objects of class Point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getX() {
        // put your code here
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
}

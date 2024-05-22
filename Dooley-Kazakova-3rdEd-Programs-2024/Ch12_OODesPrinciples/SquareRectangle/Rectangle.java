/**
 * class Rectangle.
 */
public class Rectangle {
    private double width;
    private double height;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double w) {
        this.width = w;
    }
    
    public void setHeight(double h) {
        this.height = h;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public double getWidth() {
        return this.width;
    }
}

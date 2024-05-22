/**
 * class Square
 */
public class Square extends Rectangle {
    /**
     * Constructor for objects of class Square
     */
    public Square(double side) {
        super(side, side);
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }
    
    public double getSide() {
        return super.getWidth();
    }
    
    /**
     *  we override setWidth() and setHeight()
     *  to make them behave correctly for a square
     */
    public void setWidth(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }
    
    public void setHeight(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}

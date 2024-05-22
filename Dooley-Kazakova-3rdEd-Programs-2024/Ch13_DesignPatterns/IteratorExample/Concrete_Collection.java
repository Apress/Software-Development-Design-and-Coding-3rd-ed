/**
 * class ConcreteCollection.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Concrete_Collection implements Collection_Interface {
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ConcreteCollection
     */
    public Concrete_Collection() {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y) {
        // put your code here
        return x + y;
    }
}

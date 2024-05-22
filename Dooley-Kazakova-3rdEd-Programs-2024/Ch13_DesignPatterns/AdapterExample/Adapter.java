/**
 * Write a description of class Adapter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adapter extends Adaptee implements Target {
    public int sampleMethod(int y) {
        return myMethod(y);
    }
}

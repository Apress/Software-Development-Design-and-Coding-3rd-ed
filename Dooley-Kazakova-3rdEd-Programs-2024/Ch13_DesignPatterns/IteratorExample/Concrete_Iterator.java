/**
 * class ConcreteIterator.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Concrete_Iterator<E> implements Iterator_Interface<E> {
    // instance variables - replace the example below with your own
    E x;
    
    /**
     * Constructor for objects of class ConcreteIterator
     */
    public Concrete_Iterator() { 
    }

    /**
     * An example of a method
     * 
     * @param  y   a sample parameter for a method
     * @return     y 
     */
    public boolean hasNext() {
        // put your code here
        return true;
    }
    
    public E next() {
        return x;
    }
    
    public void remove() {
    }
    
}

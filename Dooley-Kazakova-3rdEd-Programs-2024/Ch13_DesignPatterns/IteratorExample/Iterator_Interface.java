/**
 * Write a description of interface IteratorInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Iterator_Interface<E> {

    boolean hasNext();
    
    E next();
    
    void remove();
}

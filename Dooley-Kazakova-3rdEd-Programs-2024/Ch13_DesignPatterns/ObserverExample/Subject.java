/**
 * interface Subject.
 */

public interface Subject {
    public void addObserver(Observer obs);
    public void removeObserver(Observer obs);
    public void notifyAllObservers();
}

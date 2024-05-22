/**
 * class ObserverDriver
 */
public class ObserverDriver {
    public static void main(String [] args) {
        ConcreteSubject subj = new ConcreteSubject();
        
        ConcreteObserver obj = new ConcreteObserver(subj);
        
        subj.setState(12, "Monday");
        subj.setState(17, "Tuesday");
    }
}

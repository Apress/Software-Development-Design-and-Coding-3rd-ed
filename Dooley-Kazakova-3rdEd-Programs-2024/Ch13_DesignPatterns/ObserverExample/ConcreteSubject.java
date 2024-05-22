/**
 * class ConcreteSubject
 */

import java.util.ArrayList;

public class ConcreteSubject implements Subject {
    private ArrayList<Observer> observerList;
    private int foo;
    private String bar;
    
    public ConcreteSubject() {
        observerList = new ArrayList<Observer>();
        this.foo = 0;
        this.bar = "Hello";
    }

    public void addObserver(Observer obs) {
        observerList.add(obs);
        System.out.println("Added a new Observer");
        System.out.println("Number of Observers is " + observerList.size());
    }
    
    public void removeObserver(Observer obs) {
        observerList.remove(obs);
    }
    
    public void notifyAllObservers() {
        System.out.println("Notifying all Observers. size = " + observerList.size());
        for (Observer obs: observerList) {
            obs.update(this.foo, this.bar);
        }
    }
    
    public void setState(int foo, String bar) {
        this.foo = foo;
        this.bar = bar;
        notifyAllObservers();
    }
}

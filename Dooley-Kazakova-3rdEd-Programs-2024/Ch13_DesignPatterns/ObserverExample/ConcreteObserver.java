/**
 * class ConcreteObserver
 */
public class ConcreteObserver implements Observer {
    private int foo;
    private String bar;
    Subject subj;

    /**
     * Constructor for objects of class ConcreteObserver
     */
    public ConcreteObserver(Subject subj) {
        this.subj = subj;
        subj.addObserver(this);
    }
    
    public void update(int foo, String bar) {
        this.foo = foo;
        this.bar = bar;
        show();
    }
    
    private void show() {
        System.out.printf("Foo = %s Bar = %s\n", this.foo, this.bar);
    }
}

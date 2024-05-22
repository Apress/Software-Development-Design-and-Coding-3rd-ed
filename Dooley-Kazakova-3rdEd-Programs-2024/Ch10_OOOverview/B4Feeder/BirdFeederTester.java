/**
 * The class that tests the BirdFeeder, Sensor, and 
 * FeedingDoor classes.
 * 
 * @version 0.1
 */
public class BirdFeederTester {
    private BirdFeeder feeder;

    /**
     * Constructor for objects of class BirdFeederTest
     */
    public BirdFeederTester() {
        this.feeder = new BirdFeeder();
    }
    
    public static void main(String [] args) {
        BirdFeederTester bfTest = new BirdFeederTester();
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Testing the bird feeder");
            bfTest.feeder.operate();
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted" + e.getMessage());
                System.exit(1);
            }
        }
    }
}

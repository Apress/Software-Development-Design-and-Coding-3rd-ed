/**
 * class BirdFeeder.
 * 
 * @author John F. Dooley 
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;

public class BirdFeeder {
    /* instance variables */
    private static final int ON_THRESHOLD = 40;
    private static final int OFF_THRESHOLD = 25;
    private int lightLevel;
    private Sensor s1;
    private ArrayList<FeedingDoor> doors;

    /**
     * Default Constructor for objects of class BirdFeeder
     */
    public BirdFeeder() {
        doors = new ArrayList<FeedingDoor>();
        /* initialize lightLevel */
        lightLevel = 0;
        this.s1 = new Sensor();
        /* by default we have a feeder with just one door */
        doors.add(new FeedingDoor());
        
    }

    /**
     * The operate() method operates the birdfeeder.
     * It gets the current lightLevel from the Sensor and 
     * checks to see if we should open or close the doors
     */
    public void operate() {
        lightLevel = s1.getLevel();
        
        if (lightLevel > ON_THRESHOLD) {
            Iterator door_iter = doors.iterator();
            while (door_iter.hasNext()) {
                FeedingDoor a = (FeedingDoor) door_iter.next();
                a.open();
                System.out.println("Door has opened");
            }
        } else if (lightLevel < OFF_THRESHOLD) {
             Iterator door_iter = doors.iterator();
             while (door_iter.hasNext()) { 
                FeedingDoor a = (FeedingDoor) door_iter.next();
                a.close();
                System.out.println("Door has closed");
             }
        }
        return;
    }
}

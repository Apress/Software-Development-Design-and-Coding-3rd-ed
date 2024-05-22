/**
 * class BirdFeeder
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
    private ArrayList<Song> songs;
    private FeedingDoor door;

    /**
     * Default Constructor for objects of class BirdFeeder
     */
    public BirdFeeder() {
        songs = new ArrayList<Song>();
        /* initialize lightLevel and sensor */
        lightLevel = 0;
        this.s1 = new Sensor();
        /* by default we have a feeder with just one door
           in other models we have more than one
         */
        door = new FeedingDoor();
    }

    /**
     * The operate() method operates the birdfeeder.
     * It gets the current lightLevel from the Sensor and 
     * checks to see if we should open or close the doors
     */
    public void operate() {
        lightLevel = s1.getLevel();
        
        if (lightLevel > ON_THRESHOLD) {
                door.open();
                System.out.println("Door has opened");
        } else if (lightLevel < OFF_THRESHOLD) {
                door.close();
                System.out.println("Door has closed");
        }
    }
    
    public ArrayList<Song> getSongs() {
        return songs;
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }
    
    public FeedingDoor getDoor() {
        return door;
    }
}

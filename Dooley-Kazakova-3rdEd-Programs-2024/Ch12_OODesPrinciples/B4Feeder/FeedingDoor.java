/**
 * class FeedingDoor
 * 
 * @author John Dooley
 * @version 1.0
 */
public class FeedingDoor {
    /* instance variables */
    private boolean doorOpen;

    /**
     * Default constructor for objects of class FeedingDoors
     */
    public FeedingDoor() {
        /** initialise instance variables */
        doorOpen = false;
    }

    /**
     * open the feeding doors
     * if they are already open, do nothing
     */
    public void open( ) {
        /** if the door is closed, open it */
        if (doorOpen == false) {
            doorOpen = true;
        }
        return;
    }
    
    /**
     * close the doors
     * if they are already closed, do nothing
     */
    public void close( ) {
        /** if the door is open, close it */
        if (doorOpen == true) {
            doorOpen = false;
        }
        return;
    }
    
    /** 
     * report whether the doors are open or not
     */
    public boolean isOpen() {
        return doorOpen;
    }
}

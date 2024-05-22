/**
 * class RemoteControl
 * 
 * Opens a FeedingDoor using a remote control
 * 
 * @version 0.1
 */
public class RemoteControl {
    private FeedingDoor door;
    /**
     * Constructor for objects of class RemoteControl
     */
    public RemoteControl(FeedingDoor door) {
        this.door = door;
    }

    /**
     *  Press the button to open/close the door
     */
    public void pressButton() {
        if (door.isOpen()) {
            door.close();
            System.out.println("The door has closed via remote.");
        } else {
            door.open();
            System.out.println("The door has opened via remote.");
        }
    }
}

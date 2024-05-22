/**
 * class Sensor
 * 
 * @author John Dooley 
 * @version 1.0
 */
public class Sensor {
    /* instance variables */
    private int lightLevel;

    /**
     * Default constructor for objects of class Sensor
     */
    public Sensor() {
        /* initialize instance variable */
        lightLevel = 0;
    }

    /*
     * getLevel - return a light level
     * 
     * @return the value of the light level returned by the hardware sensor 
     */
    public int getLevel( ) {
        /* till we get a light sensor, we just fake it */
        lightLevel = (int) (Math.random() * 100);
        return lightLevel;
    }
}

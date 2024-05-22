/**
 * The Singleton Class
 * this is the instance that will hang around
 * This version is thread-safe.
 */
public class Singleton {

	private static Singleton uniqueInstance;

	// the private constructor – can't be accessed from outside
	private Singleton() {
		// do stuff here to initialize the instance
	}

	// here's the static method we'll use to create the instance
	public synchronized static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	/* Other methods – after all Singleton
	 * is a real class
	 */
}

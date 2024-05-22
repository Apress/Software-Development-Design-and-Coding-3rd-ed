/**
 * in order to use the Singleton class
 * we’d do something like:
 */

public class SingletonTest {

	public static void main(String [] args) {
		Singleton mySingle;

		mySingle = Singleton.getInstance();

		System.out.println("Singleton Instance" + mySingle);

		/* now try it again. Should end up with the same instance */
		mySingle = Singleton.getInstance();

		System.out.println("Singleton Instance" + mySingle);
	}
}

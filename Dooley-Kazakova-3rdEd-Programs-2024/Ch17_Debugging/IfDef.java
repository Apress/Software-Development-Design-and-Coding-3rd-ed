/**
 * illustration of conditional compilation in Java
 * or - how to fake out the Java compiler
 * jfdooley 02/23/2011 (parts retrieved from the internet)
 */

public class IfDef {
	final static boolean DEBUG = true;

	public static void main(String [] args) {
		System.out.printf("Hello World \n");

		if (DEBUG) {
		    System.out.printf("max(5, 8) is %d\n", Math.max(5, 8));
			System.out.printf("If this prints, the code was included\n");
		}
	}
}

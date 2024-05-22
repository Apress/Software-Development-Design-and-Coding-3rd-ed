/**
 * Test of how to catch a Java exception 
 */

public class TestNullCatch {
	public static void main(String[] args) {
		String str = null;

		try {
			int len = str.length();
		} catch (NullPointerException e) {
			System.out.println("Oops: " + e.getMessage());
			System.exit(1);
		}
	}
}


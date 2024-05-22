import java.util.*;

public class TestReturn {
	public static void main(String [] args) {
		Scanner stdin = new Scanner(System.in);

		System.out.println("Input some integers");
		while (stdin.hasNextInt()) {
			stdin.nextInt();
		}
		System.out.println("Done entering integers.");

		int i = 4;
		if (i = 5) {
			System.out.println("Reassigned i");
		}
	}
}

/**
 * This is the Java version of the TstEql program
 * that deliberately makes the == vs = mistake.
 * Unlike the C program, this program will not compile.
 * The objective is to see what the error message is
 */

public class TstEql
{
	public static void main(String [] args)
	{
		char [] myArray = {'a','b','c','d'};
		int pos = -1;
		char c = 'c';

		for (int j = 0; j < myArray.length; j++) {
			if (c = myArray[j]) {
				pos = j;
				break;
			}
		}
		System.out.println(pos);
	}
}


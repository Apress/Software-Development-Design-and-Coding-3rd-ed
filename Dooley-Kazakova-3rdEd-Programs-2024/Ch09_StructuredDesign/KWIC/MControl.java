import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Manage the KWIC indexing system.
 * 
 * @author jfdooley 
 *
 */

public class MControl {

    public static void main(String[] args) {
		/*
		 * usage and file opening
		 */
	
		Scanner scan = null;
		Scanner ignore = null;
		if (args.length ==  2) {
	    	try {
				scan = new Scanner(new File(args[0]));
				ignore = new Scanner(new File(args[1]));
	    	} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
	    	}

		} else {
	    	System.out.println("Usage: MControl <inputFile> <wordsToIgnore>");
			System.exit(1);
		}

		Index ind = new Index(ignore);

		// add all the lines
		while (scan.hasNextLine()) {
	    	ind.add(scan.nextLine());
		}
		// print the index
		Print prt = new Print(ind.getLines());
		prt.printIndex();
    }
}

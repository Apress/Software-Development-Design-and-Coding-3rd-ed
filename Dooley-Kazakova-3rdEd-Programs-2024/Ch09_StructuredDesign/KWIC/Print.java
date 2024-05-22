import java.util.*;

/**
 * Print  
 * 
 * @author jfdooley 
 */

public class Print {
    public PriorityQueue<Line> lines;

    public Print(PriorityQueue<Line> lines) {
		this.lines = lines;
    }

    /**
     * Print to System.out the contents of the index
	 * lines formatting adjusted so
     * keywords are in the same column
     */
    public void printIndex() {
		// make a new PriorityQueue
		PriorityQueue<Line> newLines = new PriorityQueue<Line>();

		// lets figure out the longest line
		int longest = 0;
		for (Line l : lines) {
	    	if (l.indexOf > longest) {
				longest = l.indexOf;
	    	}
		}

		// do the printing
		while (!lines.isEmpty()) {
	    	Line l = lines.poll();

	    	// save the line
	    	newLines.add(l);

	    	// figure out the whitespace
	    	String retval = "";
	    	for (int i = 0; i < (longest - l.indexOf); i++) {
				retval += " ";
	    	}

	    	// construct the line and print
	    	retval += l.line;
	    	System.out.println(retval);
		}
		// Save the lines from all that polling
		this.lines = newLines;
    }
}

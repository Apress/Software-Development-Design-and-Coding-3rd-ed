import java.util.Scanner;
import java.util.*;

/**
 * Index contains a collection of Lines and the words we are ignoring as
 * keywords.
 * 
 * @author jfdooley 
 */

public class Index {
    public HashSet<String> wordsToIgnore;
    public PriorityQueue<Line> lines;

    public Index(Scanner ignore) {
		this.wordsToIgnore = new HashSet<String>();
		this.lines = new PriorityQueue<Line>();

		while (ignore.hasNext()) {
			this.wordsToIgnore.add(ignore.next());
		}
    }

    /**
     * Create an entry in the index for the given line.
     * @param str; a string to examine
     * @return
     */
    public boolean add(String str) {
		Scanner scan = new Scanner(str);

		int offset = 0;
		int words = -1;
		while (scan.hasNext()) {
	    	String temp = scan.next();
	    	words++;
	    	if (!wordsToIgnore.contains(temp.toLowerCase())) {
				Line version = new Line(str, temp, offset + words);
				this.lines.add(version);
	    	}
	    	offset += temp.length();
		}
		return true;
    }

	/*
	 * return the index so we can print it
	 */
	public PriorityQueue<Line> getLines() {
		return lines;
	}
}

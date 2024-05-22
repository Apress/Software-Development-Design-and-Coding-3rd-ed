/**
 * Handle the storage of 3 key pieces of information.
 * Basically just like a struct in C.
 * 
 * @author jfdooley 
 */

public class Line implements Comparable<Line> {
    public String line;
    public String keyword;
    public int indexOf;

    public Line(String line, String keyword, int indexOf) {
		this.keyword = keyword;
		this.indexOf = indexOf;

		// capitalize the keyword in the line
		String first = line.substring(0, indexOf);
		String middle = keyword.toUpperCase();
		String last = line.substring(indexOf + keyword.length());
		this.line = first + middle + last;
    }

    /**
     * Eclipse auto-generated hashCode.
     */
    @Override
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + indexOf;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		return result;
    }

    /**
     * Eclipse auto-generated equals.
     */
    @Override
    public boolean equals(Object obj) {
		if (this == obj) {
	    	return true;
		}
		if (obj == null) {
	    	return false;
		}
		if (!(obj instanceof Line)) {
	    	return false;
		}

		Line other = (Line) obj;
		if (indexOf != other.indexOf) {
	    	return false;
		}
		if (keyword == null) {
	    	if (other.keyword != null) {
				return false;
			}
		} else if (!keyword.equals(other.keyword)) {
	    	return false;
		}

		if (line == null) {
	    	if (other.line != null) {
				return false;
			}
		} else if (!line.equals(other.line)) {
	    	return false;
		}

		return true;
    }

    /**
     * We want to sort lines based on keyword alone.
     * This will do a lexicographical comparison of the keywords
     */
    @Override
    public int compareTo(Line other) {
		return this.keyword.compareToIgnoreCase(other.keyword);
    }
}

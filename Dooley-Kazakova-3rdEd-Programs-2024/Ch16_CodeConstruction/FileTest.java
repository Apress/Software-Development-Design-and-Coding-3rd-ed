import java.io.*;
import java.util.*;

public class FileTest {
	public static void main(String [] args) {
		File fd = new File("NotAFile.txt");
		System.out.println("File exists? " + fd.exists());

		try {
			FileReader fr = new FileReader(fd);
		} catch (FileNotFoundException e) {
			System.out.println("NotAFile.txt " + e.getMessage());
		}
	}

}

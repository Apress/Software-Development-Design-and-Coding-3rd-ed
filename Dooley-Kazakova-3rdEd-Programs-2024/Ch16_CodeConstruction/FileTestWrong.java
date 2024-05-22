import java.io.*;
import java.util.*;

/**
 * Illustration of how not to use the File type
 * This program will not compile.
 */

public class FileTestWrong {
	public static void main(String [] args) {
		File fd = new File("NotAFile.txt");
		System.out.println("File exists " + fd.exists());

		FileReader fr = new FileReader(fd);
	}
}

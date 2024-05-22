import java.util.*;

/**
 * class ArrayIdioms.
 */
public class ArrayIdioms {
    private static int [] myArray = {2, 4, 6, 8, 10, 12, 14, 16, 18, 1, 3, 5, 7, 9};

    /**
     * Constructor for objects of class ArrayIdioms
     */
    public ArrayIdioms() {
    }

    /**
     * iterating through an array using for and foreach
     */
    public static void main(String [] args) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.printf(" %d ", myArray[i]);
        }
        System.out.println();
        
        for (int nextElement: myArray) {
            System.out.printf(" %d ", nextElement);
        }
        System.out.println();
    }
}

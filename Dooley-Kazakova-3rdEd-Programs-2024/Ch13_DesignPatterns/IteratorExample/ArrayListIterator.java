/**
  * Iterate through elements Java ArrayList using an Iterator
  * We then use ListIterator to go backwards through the same
  * ArrayList 
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIterator {
    public static void main(String[] args) {
        //create an ArrayList object
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //Add elements to Arraylist
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(11);
        arrayList.add(13);
        arrayList.add(17);
        
        //get an Iterator object for ArrayList
        Iterator iter = arrayList.iterator();
        System.out.println("Iterating through ArrayList elements...");
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        ListIterator list_iter = arrayList.listIterator(arrayList.size());
        System.out.println("Iterating through ArrayList elements backwards...");
        while(list_iter.hasPrevious()) {
            System.out.println(list_iter.previous());
        }
    }
}

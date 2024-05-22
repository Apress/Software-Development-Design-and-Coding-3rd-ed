/**
 * class PhoneContactList here.
 */

import java.util.*;
import java.io.*;

public class PhoneContactList {
    private TreeMap<String, PhoneContact> phoneList;
    private Scanner phoneFile;
    
    /**
     * Constructors for objects of class PhoneContactList
     */
    public PhoneContactList() {
    
    }
    
    public PhoneContactList(PhoneContact pc) {
         phoneList = new TreeMap<String, PhoneContact>();
         phoneList.put(pc.getLastName(), pc);
    }

    public boolean fileOpen(String name) {
        try {
            phoneFile = new Scanner(new File(name));
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

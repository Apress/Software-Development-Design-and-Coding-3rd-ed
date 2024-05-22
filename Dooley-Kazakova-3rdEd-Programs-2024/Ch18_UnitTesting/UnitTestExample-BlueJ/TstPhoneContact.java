/**
 * class TstPhoneContact here.
 */

import java.util.*;
import java.io.*;

public class TstPhoneContact {
    /**
     * Default constructor for test class TestPhoneContact
     */
    public TstPhoneContact() {
    
    }
    
    public void testPhoneContactCreation() {
        String fname = "Fred";
        String lname = "Flintstone";
        String phone = "800-555-1212";
        String email = "fred@knox.edu";
        
        PhoneContact t1 = new PhoneContact();
        System.out.printf("Phone Contact reference is %H\n", t1);
        
        PhoneContact t2 = new PhoneContact(fname, lname, phone, email);
        System.out.printf("Phone Contact:\n Name = %s\n Phone = %s\n Email = %s\n", 
                            t2.getName(), t2.getPhoneNum(), t2.getEmailAddr());
    }
    
    public void testFileOpen() {
        String fileName = "phoneList.txt";
        
        PhoneContactList pc = new PhoneContactList();
        boolean fileOK = pc.fileOpen(fileName);
        
        if (fileOK == false) {
            System.out.println("Open Failed, File Not Found");
            System.exit(1);
        }
    }
}

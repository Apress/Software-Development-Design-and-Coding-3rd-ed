/**
 * The test class TestPhoneContact.
 *
 * @author  jfd
 * @version 10/21/2010
 */

import java.util.*;
import java.io.*;
import junit.framework.*;

public class TestPhoneContact extends TestCase {
    /**
     * Default constructor for test class TestPhoneContact
     */
    public TestPhoneContact() {
    
    }

    /**
     * JUnit method to Set up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp() {
    
    }

    /**
     * JUnit method to tear down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown() {
    
    }
    
	/**
	 * first test method
	 */
    public void testPhoneContactCreation() {
        String fname = "Fred";
        String lname = "Flintstone";
        String phone = "800-555-1212";
        String email = "fred@knox.edu";
        
        PhoneContact t1 = new PhoneContact();
        PhoneContact t2 = new PhoneContact(fname, lname, phone, email);
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

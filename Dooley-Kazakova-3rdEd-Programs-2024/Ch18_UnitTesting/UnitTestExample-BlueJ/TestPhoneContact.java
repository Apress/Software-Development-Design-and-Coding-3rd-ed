/**
 * The test class TestPhoneContact.
 *
 * @author  jfd
 * @version 10/21/2010
 */

public class TestPhoneContact extends junit.framework.TestCase {
    /**
     * Default constructor for test class TestPhoneContact
     */
    public TestPhoneContact(String name) {
        super(name);
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp() {
    
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown() {
    
    }
    
    public void testPhoneContactCreation() {
        String fname = "Fred";
        String lname = "Flintstone";
        String phone = "800-555-1212";
        String email = "fred@knox.edu";
        
        PhoneContact pc = new PhoneContact(fname, lname, phone, email);
        assertEquals(lname, pc.getLastName());
        assertEquals(fname, pc.getFirstName());
        assertEquals(phone, pc.getPhoneNum());
        assertEquals(email, pc.getEmailAddr());
    }
    
    public void testFileOpen() {
        String fileName = "phoneList.txt";
        
        PhoneContactList pc = new PhoneContactList();
        boolean fileOK = pc.fileOpen(fileName);
        assertTrue(fileOK);
        
        if (fileOK == false) {
            System.out.println("Open Failed, File Not Found");
            System.exit(1);
        }
    }
}

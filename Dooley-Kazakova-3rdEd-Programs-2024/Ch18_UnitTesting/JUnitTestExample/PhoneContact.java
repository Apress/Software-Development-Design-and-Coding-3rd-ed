/**
 * class PhoneContact.
 * simple contacts entry intended for a 
 * phone contacts database.
 * 
 * @author jfdooley 
 * @version 0.1
 */
public class PhoneContact {
    /**
     * instance variables
     */
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String emailAddr;

    /**
     * Constructors for objects of class PhoneContact
     */
    public PhoneContact() {
        lastName = "";
        firstName = "";
        phoneNumber = "";
        emailAddr = "";
    }
    
    public PhoneContact(String firstName, String lastName,
                        String phoneNumber, String emailAddr) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.emailAddr = emailAddr;
    }

    /**
     * Getter and Setter methods for each of the instance variables
     */
    public String getName() {
       return this.lastName + ", " + this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getPhoneNum() {
        return this.phoneNumber;
    }
    
    public String getEmailAddr() {
        return this.emailAddr;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setPhoneNum(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    } 
}

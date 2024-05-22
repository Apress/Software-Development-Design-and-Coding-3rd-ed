/**
 * class Client.
 */
public class Client {
    public static void main(String [] args) {
        Target myTarget = new Adapter();
        
        System.out.println(myTarget.sampleMethod(12));
    }
}

public class Fan implements Switch {

    public void switchOn() {
        System.out.println("FAN Switched ON");
    }
    
    public void switchOff() {
        System.out.println("FAN Switched OFF");
    }

    public static void main(String arg[]){
        Fan f = new Fan();
        f.switchOn();
        f.switchOff();
    }
}

/**
 * The class that tests the BirdFeeder, Sensor, and 
 * FeedingDoor classes.
 * 
 * @version 0.1
 */
public class BirdFeederTester {

    public static void main(String [] args) {
        BirdFeeder feeder = new BirdFeeder();
        RemoteControl remote = new RemoteControl(new FeedingDoor());
        
        System.out.println("Pressing the remote control button");
        remote.pressButton();
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Testing the bird feeder");
            feeder.operate();
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted" + e.getMessage());
                System.exit(1);
            }
        }
        System.out.println("Pressing the remote control button again");
        remote.pressButton();
        
        feeder.addSong(new Song("Tweet Tweet"));
        feeder.addSong(new Song("Chirp"));
        feeder.addSong(new Song("Cheep"));
        
        System.out.println("Song heard");
        SongIdentifier songId = new SongIdentifier(feeder);
        songId.identify(new Song("Cheep"));
        
    }
}

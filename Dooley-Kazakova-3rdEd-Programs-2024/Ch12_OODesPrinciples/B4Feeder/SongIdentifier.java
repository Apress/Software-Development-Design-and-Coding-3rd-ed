import java.util.*;
/**
 * class SongIdentifier
 * 
 * The feeder must identify song types.
 * @version 0.1
 */
public class SongIdentifier {
  /*
   * the SongIdentifier has to send a signal to the
   * door to open, so we need to know about a door..
   * Later we could know about a list of doors.
   */
  private BirdFeeder feeder;
  private FeedingDoor door;
  
  /*
   * constructor
   */
  public SongIdentifier(BirdFeeder feeder) {
    this.feeder = feeder;
    this.door = feeder.getDoor();
  }
  
  /*
   * Identify a song that is sent to us by the song hardware.
   * If the song is in our list then we open the door
   * otherwise the bird singing the song is not one we want
   * to feed, so we close the door.
   */
  public void identify(Song song) {
    List<Song> songs = feeder.getSongs();
    
    Iterator<Song> song_iter = songs.iterator();
    
    while (song_iter.hasNext()) {
        Song nxtSong = song_iter.next();
        if (nxtSong.equals(song)) {
            System.out.println("The song is identified and the door is open");
            door.open();
            return;
        }
    }
    System.out.println("The song is not identified");
    door.close();
  }
}

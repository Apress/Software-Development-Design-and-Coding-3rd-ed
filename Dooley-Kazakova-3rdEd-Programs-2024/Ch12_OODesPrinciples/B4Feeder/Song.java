/**
 * The Song class
 * 
 * @version 0.1
 */
public class Song {
    private String song;
  
    /**
     * constructors
     */
    public Song(String song) {
        this.song = song;
    }
  
    /**
     * return the song
     */
    public String getSong() {
        return this.song;
    }
  
    /**
     * Is this song the same as some other song?
     */
    public boolean equals(Object newSong) {
        if (newSong instanceof Song) {
            Song newSong2 = (Song) newSong;
      
            if (this.song.equals(newSong2.song)) {
                return true;
            }
        }
        return false;
    }
}

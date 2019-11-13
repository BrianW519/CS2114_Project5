/**
 * 
 */
package prj5;

/**
 * @author davidd14
 * @version 2019.11.13
 *
 */
public class Stats {
    
    private SubEnum sub;
    private int likes;
    private int dislikes;
    private int heardSong;
    
    public Stats(SubEnum sub) {
        likes = 0;
        dislikes = 0;
        heardSong = 0;
        this.sub = sub;
    }
    
    public void like() {
        likes++;
        heardSong++;
    }
    
    public void dislike() {
        dislikes++;
        heardSong++;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public int getDislikes() {
        return dislikes;
    }
    
    public int getHeardSong() {
        return heardSong;
    }
    
    public SubEnum getSubCategory() {
        return sub; 
    }

}
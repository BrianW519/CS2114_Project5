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

    // fields
    private SubEnum sub;
    private int likes;
    private int dislikes;
    private int heardSong;


    /**
     * Constructs a new Stats object
     * 
     * @param sub
     *            The subcategory associated with the stats
     */
    public Stats(SubEnum sub) {
        likes = 0;
        dislikes = 0;
        heardSong = 0;
        this.sub = sub;
    }


    /**
     * increments the number of people who like the song and and people who have
     * heard the song
     */
    public void like() {
        likes++;
        heardSong++;
    }


    /**
     * increments the number of people who dislike the song and and people who
     * have heard the song
     */
    public void dislike() {
        dislikes++;
        heardSong++;
    }


    /**
     * returns the number of people who like the song
     * 
     * @return
     *         returns the number of people who like the song
     */
    public int getLikes() {
        return likes;
    }


    /**
     * returns the number of people who dislike the song
     * 
     * @return
     *         returns the number of people who dislike the song
     */
    public int getDislikes() {
        return dislikes;
    }


    /**
     * returns the number of people who have heard the song
     * 
     * @return
     *         returns the number of people who have heard the song
     */
    public int getHeardSong() {
        return heardSong;
    }


    /**
     * returns the subcategory associated with these stats
     * 
     * @return
     *         returns the subcategory associated with these stats
     */
    public SubEnum getSubCategory() {
        return sub;
    }

}

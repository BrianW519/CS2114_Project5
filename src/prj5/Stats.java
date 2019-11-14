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


    /**
     * returns true if object is another stats object with equivalent
     * subcategory, likes, dislikes, and heardSong
     * 
     * @param obj
     *            the other object to compare to
     * @return
     *         returns true if the other object is another stats object with
     *         equivalent subcategory, likes, dislikes, and heardSong
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == this.getClass()) {
            Stats other = (Stats)obj;
            return (sub.equals(other.getSubCategory()) && likes == other
                .getLikes() && dislikes == other.getDislikes());
        }
        return false;
    }


    /**
     * returns Stats as a String
     * 
     * @return
     *         returns as a string in the following for "(SubCatergory) student:
     *         Likes: (likes), Dislikes (dislikes), Total Heard: (heardSong)."
     */
    @Override
    public String toString() {
        return sub.toString() + " students: Likes: " + likes + ", Dislikes: "
            + dislikes + ", Total Heard: " + heardSong + ".";
    }

}

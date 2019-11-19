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
    private int notHeardSong;


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
        notHeardSong = 0;
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
     * increments the amount of people that havent heard the song
     */
    public void notHeard() {
        notHeardSong++;
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
     * returns the number of people who have not heard the song
     * 
     * @return
     *         returns the number of people who have not heard the song
     */
    public int getNotHeardSong() {
        return notHeardSong;
    }


    /**
     * Returns the percent of people who have heard it
     * 
     * @return the % of people that heard the song
     */
    public int getHeardPercent() {
        if (notHeardSong + heardSong > 0) {
            return (heardSong / (heardSong + notHeardSong)) * 100;
        }
        else {
            return 0;
        }
    }


    /**
     * Returns the percent of people who have liked it
     * 
     * @return the % of people that liked the song
     */
    public int getLikePercent() {
        if (notHeardSong + heardSong > 0) {
            return (likes / (heardSong + notHeardSong)) * 100;
        }
        else {
            return 0;
        }
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

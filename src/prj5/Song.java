package prj5;

import java.util.Comparator;

/**
 * Description
 *
 * @author Brian Wood brianwood
 * @author Dave
 * @author David
 * @version Nov 13, 2019
 */
public class Song implements Comparator<Song> {

    // fields
    private String title;
    private String artistName;
    private String genre;
    private int date;
    private Category hobby;
    private Category major;
    private Category region;


    /**
     * Constructs a new Song object
     * 
     * @param title
     *            title of the song
     * @param artist
     *            artist of the song
     * @param genre
     *            genre of the song
     * @param date
     *            year the song was released
     */
    public Song(String title, String artist, String genre, int date) {
        this.title = title;
        artistName = artist;
        this.genre = genre;
        this.date = date;
        hobby = new Category(SubEnum.MUSIC, SubEnum.ART, SubEnum.SPORTS,
            SubEnum.READ);
        major = new Category(SubEnum.COMPUTER_SCIENCE,
            SubEnum.OTHER_ENGINEERING, SubEnum.MATH_CMDA, SubEnum.OTHER);
        region = new Category(SubEnum.NORTHEAST_USA, SubEnum.SOUTHEAST_USA,
            SubEnum.USA_OTHER, SubEnum.OUTSIDE_USA);
    }


    /**
     * updates the info associated with a song review
     * 
     * @param hobbyType
     *            reviewee's hobby
     * @param majorType
     *            reviewee's major
     * @param regionType
     *            reviewee's region
     * @param likes
     *            greater than 0 for a like, 0 or less for a dislike
     */
    public void updateData(
        SubEnum hobbyType,
        SubEnum majorType,
        SubEnum regionType,
        int likes) {
        this.hobby.updateData(hobbyType, likes);
        this.major.updateData(majorType, likes);
        this.region.updateData(regionType, likes);
    }


    /**
     * gets the category object
     * 
     * @param category
     *            the category associated with the required stats
     * @return the category
     */
    public Category getCategory(CategoryEnum category) {
        if (category.equals(CategoryEnum.HOBBY)) {
            return hobby;
        }
        else if (category.equals(CategoryEnum.MAJOR)) {
            return major;
        }
        else {
            return region;
        }
    }


    /**
     * gets the song genre
     * 
     * @return
     *         returns the songs genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * gets the songs release year
     * 
     * @return
     *         returns the songs release year
     */
    public int getDate() {
        return date;
    }


    /**
     * gets the songs title
     * 
     * @return
     *         returns the songs title
     */
    public String getTitle() {
        return title;
    }


    /**
     * gets the songs artist
     * 
     * @return
     *         returns the songs artist
     */
    public String getArtistName() {
        return artistName;
    }


    /**
     * Converts the songs data into a string
     * 
     * @return a string of the songs data
     */
    public String toString() {
        return title + ", " + artistName + ", " + date + ", " + genre;

    }

    /**
     * A new comparator to compare songs by their title
     */
    public static final Comparator<Song> COMPARE_BY_TITLE =
        new Comparator<Song>() {
            /**
             * Compare song 1 and song 2 by their title
             * 
             * @param o1
             *            the first song
             * @param o2
             *            the second song
             * @return an int based on the songs data comparison
             */
            public int compare(Song o1, Song o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };

    /**
     * A new comparator to compare songs by their genre
     */
    public static final Comparator<Song> COMPARE_BY_GENRE =
        new Comparator<Song>() {
            /**
             * Compare song 1 and song 2 by their Genre
             * 
             * @param o1
             *            the first song
             * @param o2
             *            the second song
             * @return an int based on the songs data comparison
             */
            public int compare(Song o1, Song o2) {
                return o1.getGenre().compareTo(o2.getGenre());
            }
        };

    /**
     * A new comparator to compare songs by their artist name
     */
    public static final Comparator<Song> COMPARE_BY_ARTIST =
        new Comparator<Song>() {
            /**
             * Compare song 1 and song 2 by their artist
             * 
             * @param o1
             *            the first song
             * @param o2
             *            the second song
             * @return an int based on the songs data comparison
             */
            public int compare(Song o1, Song o2) {
                return o1.getArtistName().compareTo(o2.getArtistName());
            }
        };

    /**
     * A new comparator to compare songs by their date
     */
    public static final Comparator<Song> COMPARE_BY_DATE =
        new Comparator<Song>() {
            /**
             * Compare song 1 and song 2 by their date
             * 
             * @param o1
             *            the first song
             * @param o2
             *            the second song
             * @return an int based on the songs data comparison
             */
            public int compare(Song o1, Song o2) {
                if (o1.getDate() < o2.getDate()) {
                    return -1;
                }
                else if (o1.getDate() > o2.getDate()) {
                    return 1;
                }
                return 0;
            }
        };


    /**
     * Default compare by the songs title
     * 
     * @param o1
     *            the first song
     * @param o2
     *            the second song
     * @return -1 if the first songs title is alphabetically lower than the
     *         second, 1 if its higher, and 0 if they are the same title
     */
    @Override
    public int compare(Song o1, Song o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}

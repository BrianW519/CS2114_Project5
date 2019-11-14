package prj5;

/**
 * Description
 *
 * @author Brian Wood brianwood
 * @author Dave
 * @author David
 * @version Nov 13, 2019
 */
public class Song implements Comparable<Song>{

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
     * @param hobby
     *            reviewee's hobby
     * @param major
     *            reviewee's major
     * @param region
     *            reviewee's region
     * @param likes
     *            greater than 0 for a like, 0 or less for a dislike
     */
    public void updateData(
        SubEnum hobby,
        SubEnum major,
        SubEnum region,
        int likes) {
        this.hobby.updateData(hobby, likes);
        this.major.updateData(major, likes);
        this.region.updateData(region, likes);
    }

    /**
     * gets the category object 
     * @param category
     *          the category associated with the required stats 
     * @return
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
     * @return
     *          returns the songs genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * gets the songs release year
     * @return
     *          returns the songs release year
     */
    public int getDate() {
        return date;
    }

    /**
     * gets the songs title
     * @return
     *          returns the songs title
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets the songs artist
     * @return
     *          returns the songs artist
     */
    public String getArtistName() {
        return artistName;
    }


    @Override
    public int compareTo(Song o) {
        // TODO Auto-generated method stub
        return 0;
    }

}

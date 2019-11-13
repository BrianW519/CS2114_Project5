package prj5;

/**
 * Description
 *
 * @author Brian Wood brianwood
 * @author Dave
 * @author David
 * @version Nov 13, 2019
 */
public class Song {

    private String title;
    private String artistName;
    private String genre;
    private int date;
    private Category hobby;
    private Category major;
    private Category region;


    public Song(String title, String artist, String genre, int date) {
        this.title = title;
        artistName = artist;
        this.genre = genre;
        this.date = date;

    }
    
    public void updateData(SubEnum hobby, SubEnum major, SubEnum region, int likes) {
        
    }
    
    public Category getCategory(Category x) {
        
        return null;
    }

}

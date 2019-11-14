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
        hobby = new Category(SubEnum.MUSIC, SubEnum.ART, SubEnum.SPORTS,
            SubEnum.READ);
        major = new Category(SubEnum.COMPUTER_SCIENCE, SubEnum.OTHER_ENGINEERING, SubEnum.MATH_CMDA,
            SubEnum.OTHER);
        region = new Category(SubEnum.NORTHEAST_USA, SubEnum.SOUTHEAST_USA,
            SubEnum.USA_OTHER, SubEnum.OUTSIDE_USA);
    }


    public void updateData(
        SubEnum hobby,
        SubEnum major,
        SubEnum region,
        int likes) {
        this.hobby.updateData(hobby, likes);
        this.major.updateData(major, likes);
        this.region.updateData(region, likes);
    }


    public Category getCategory(CategoryEnum x) {
        if (x.equals(CategoryEnum.HOBBY)) {
            return hobby;
        }
        else if (x.equals(CategoryEnum.MAJOR)) {
            return major;
        }
        else {
            return region;
        }
    }

}

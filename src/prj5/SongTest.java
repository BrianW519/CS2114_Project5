/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author davidd14
 * @version 2019.11.13
 */
public class SongTest extends TestCase {

    // fields
    private Song song;


    /**
     * sets up the test class
     */
    public void setUp() {
        song = new Song("More Than a Feeling", "Boston", "Classic Rock", 2010);
    }


    /**
     * tests updateData()
     */
    public void testUpdateData() {
        assertEquals(0, song.getCategory(CategoryEnum.HOBBY).getStats(1).getLikes());
        assertEquals(0, song.getCategory(CategoryEnum.MAJOR).getStats(1).getLikes());
        assertEquals(0, song.getCategory(CategoryEnum.REGION).getStats(1).getLikes());
        song.updateData(SubEnum.MUSIC, SubEnum.COMPUTER_SCIENCE, SubEnum.NORTHEAST_USA, 1);
        assertEquals(1, song.getCategory(CategoryEnum.HOBBY).getStats(1).getLikes());
        assertEquals(1, song.getCategory(CategoryEnum.MAJOR).getStats(1).getLikes());
        assertEquals(1, song.getCategory(CategoryEnum.REGION).getStats(1).getLikes());
    }


    /**
     * tests getCategory()
     */
    public void testGetCategory() {
        assertTrue(song.getCategory(CategoryEnum.HOBBY).getStats(1)
            .getSubCategory().equals(SubEnum.MUSIC));
        assertTrue(song.getCategory(CategoryEnum.MAJOR).getStats(1)
            .getSubCategory().equals(SubEnum.COMPUTER_SCIENCE));
        assertTrue(song.getCategory(CategoryEnum.REGION).getStats(1)
            .getSubCategory().equals(SubEnum.NORTHEAST_USA));
    }


    /**
     * test getGenre()
     */
    public void testGetGenre() {
        assertTrue(song.getGenre().equals("Classic Rock"));
    }


    /**
     * tests getDate()
     */
    public void testGetDate() {
        assertEquals(2010, song.getDate());
    }


    /**
     * tests getTitle()
     */
    public void testGetTitle() {
        assertTrue(song.getTitle().equals("More Than a Feeling"));
    }


    /**
     * tests getArtistName()
     */
    public void testGetArtistName() {
        assertTrue(song.getArtistName().equals("Boston"));
    }

}

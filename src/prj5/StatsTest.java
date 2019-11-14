/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author davidd14
 * @version 2019.11.13
 */
public class StatsTest extends TestCase {

    // fields
    private Stats stats;


    /**
     * sets up the test class
     */
    public void setUp() {
        stats = new Stats(SubEnum.MUSIC);
    }

    /**
     * tests like()
     */
    public void testLike() {
        assertEquals(0, stats.getLikes());
        assertEquals(0, stats.getHeardSong());
        assertEquals(0, stats.getDislikes());
        stats.like();
        assertEquals(1, stats.getLikes());
        assertEquals(1, stats.getHeardSong());
        assertEquals(0, stats.getDislikes());
    }

    /**
     * tests dislike()
     */
    public void testDislike() {
        assertEquals(0, stats.getLikes());
        assertEquals(0, stats.getHeardSong());
        assertEquals(0, stats.getDislikes());
        stats.dislike();
        assertEquals(0, stats.getLikes());
        assertEquals(1, stats.getHeardSong());
        assertEquals(1, stats.getDislikes());
    }

    /**
     * tests getLikes()
     */
    public void testGetLikes() {
        assertEquals(0, stats.getLikes());
        stats.like();
        assertEquals(1, stats.getLikes());
    }

    /**
     * tests getDislikes()
     */
    public void testGetDislikes() {
        assertEquals(0, stats.getDislikes());
        stats.dislike();
        assertEquals(1, stats.getDislikes());
    }

    /**
     * tests getHeardSong()
     */
    public void testGetHeardSong() {
        assertEquals(0, stats.getHeardSong());
        stats.like();
        stats.like();
        stats.dislike();
        assertEquals(3, stats.getHeardSong());
    }

    /**
     * tests getSubCategory()
     */
    public void testGetSubCategory() {
        assertTrue(stats.getSubCategory().equals(SubEnum.MUSIC));
    }

}

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

    /**
     * tests equals()
     */
    public void testEquals() {
        assertTrue(stats.equals(stats));
        Stats nullStats = null;
        assertFalse(stats.equals(nullStats));
        Stats diff1 = new Stats(SubEnum.MUSIC);
        Stats diff2 = new Stats(SubEnum.MUSIC);
        Stats diff3 = new Stats(SubEnum.ART);
        Stats same = new Stats(SubEnum.MUSIC);
        stats.like();
        stats.dislike();
        diff1.like();
        diff2.dislike();
        diff3.like();
        diff3.dislike();
        same.dislike();
        same.like();
        assertFalse(stats.equals(diff1));
        assertFalse(stats.equals(diff2));
        assertFalse(stats.equals(diff3));
        assertTrue(stats.equals(same));
    }

    /**
     * tests toString()
     */
    public void testToString() {
        stats.like();
        stats.like();
        stats.like();
        stats.dislike();
        assertTrue(stats.toString().equals(
            "MUSIC students: Likes: 3, Dislikes: 1, Total Heard: 4."));
    }

}

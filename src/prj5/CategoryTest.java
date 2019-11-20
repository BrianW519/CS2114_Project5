/**
 * 
 */
package prj5;

// imports
import student.TestCase;

/**
 * @author davidd14
 * @version 2019.11.13
 */
public class CategoryTest extends TestCase {

    // fields
    private Category hobbies;


    /**
     * sets up the test class
     */
    public void setUp() {
        hobbies = new Category(SubEnum.MUSIC, SubEnum.ART, SubEnum.SPORTS,
            SubEnum.READ);
    }


    /**
     * Test the getStats method
     */
    public void testGetStats() {
        assertTrue(hobbies.getStats(1).getSubCategory().equals(SubEnum.MUSIC));
        assertTrue(hobbies.getStats(2).getSubCategory().equals(SubEnum.ART));
        assertTrue(hobbies.getStats(3).getSubCategory().equals(SubEnum.SPORTS));
        assertTrue(hobbies.getStats(4).getSubCategory().equals(SubEnum.READ));
        Exception thrown = null;
        try {
            hobbies.getStats(0);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        thrown = null;
        try {
            hobbies.getStats(5);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }


    /**
     * tests updateData()
     */
    public void testUpdateData() {
        assertEquals(0, hobbies.getStats(1).getLikes());
        assertEquals(0, hobbies.getStats(1).getDislikes());
        hobbies.updateData(SubEnum.MUSIC, 1);
        assertEquals(1, hobbies.getStats(1).getLikes());
        assertEquals(0, hobbies.getStats(1).getDislikes());
        hobbies.updateData(SubEnum.MUSIC, -1);
        assertEquals(1, hobbies.getStats(1).getLikes());
        assertEquals(1, hobbies.getStats(1).getDislikes());
        Exception thrown = null;
        try {
            hobbies.updateData(SubEnum.COMPUTER_SCIENCE, -1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        hobbies.updateData(SubEnum.MUSIC, 100);
        assertEquals(1, hobbies.getStats(1).getLikes());
    }


    /**
     * tests toString()
     */
    public void testToString() {
        assertTrue(hobbies.toString().equals(
            "MUSIC students: Likes: 0, Dislikes: 0, Total Heard: 0.\n"
                + "ART students: Likes: 0, Dislikes: 0, Total Heard: 0.\n"
                + "SPORTS students: Likes: 0, Dislikes: 0, Total Heard: 0.\n"
                + "READ students: Likes: 0, Dislikes: 0, Total Heard: 0."));
    }


    /**
     * tests equals()
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        Category diff1 = new Category(SubEnum.NORTHEAST_USA, SubEnum.ART,
            SubEnum.SPORTS, SubEnum.READ);
        Category diff2 = new Category(SubEnum.MUSIC, SubEnum.NORTHEAST_USA,
            SubEnum.SPORTS, SubEnum.READ);
        Category diff3 = new Category(SubEnum.MUSIC, SubEnum.ART,
            SubEnum.NORTHEAST_USA, SubEnum.READ);
        Category diff4 = new Category(SubEnum.MUSIC, SubEnum.ART,
            SubEnum.SPORTS, SubEnum.NORTHEAST_USA);
        Category nullCategory = null;
        Category same = new Category(SubEnum.MUSIC, SubEnum.ART, SubEnum.SPORTS,
            SubEnum.READ);
        assertTrue(hobbies.equals(hobbies));
        assertFalse(hobbies.equals(nullCategory));
        assertFalse(hobbies.equals(diff1));
        assertFalse(hobbies.equals(diff2));
        assertFalse(hobbies.equals(diff3));
        assertFalse(hobbies.equals(diff4));
        assertTrue(hobbies.equals(same));
        String someString = "Yang Gang";
        assertFalse(hobbies.equals(someString));
    }

}

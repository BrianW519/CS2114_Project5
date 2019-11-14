/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author davidd14
 * @version 2019.11.13
 */
public class CategoryTest extends TestCase {

    private Category hobbies;


    public void setUp() {
        hobbies = new Category(SubEnum.MUSIC, SubEnum.ART, SubEnum.SPORTS,
            SubEnum.READ);
    }


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
    }

}

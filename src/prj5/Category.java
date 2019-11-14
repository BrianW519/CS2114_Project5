/**
 * 
 */
package prj5;

/**
 * @author davidd14
 * @version 2019.11.13
 *
 */
public class Category {

    // fields
    private Stats stats1;
    private Stats stats2;
    private Stats stats3;
    private Stats stats4;


    /**
     * creates a category object
     * 
     * @param sub1
     *            one of the SubEnum's associated with the category
     * @param sub2
     *            one of the SubEnum's associated with the category
     * @param sub3
     *            one of the SubEnum's associated with the category
     * @param sub4
     *            one of the SubEnum's associated with the category
     */
    public Category(SubEnum sub1, SubEnum sub2, SubEnum sub3, SubEnum sub4) {
        stats1 = new Stats(sub1);
        stats2 = new Stats(sub2);
        stats3 = new Stats(sub3);
        stats4 = new Stats(sub4);
    }


    /**
     * gets one of four stats associated with an integer 1-4
     * 
     * @param i
     *            an integer from 1 to 4
     * @return
     *         the stats associated with the integer
     */
    public Stats getStats(int i) {
        if (i < 1 || i > 4) {
            throw new IndexOutOfBoundsException();
        }
        switch (i) {
            case 1:
                return stats1;
            case 2:
                return stats2;
            case 3:
                return stats3;
            default:
                return stats4;
        }
    }


    /**
     * Updates the stats for the enum
     * 
     * @param sub
     *            the subcategory to update
     * @param j
     *            a value greater than 0 indicating a like and anything else
     *            indicating a dislike
     */
    public void updateData(SubEnum sub, int j) {
        Stats chosen = null;
        for (int i = 1; i <= 4; i++) {
            if (getStats(i).getSubCategory().equals(sub)) {
                chosen = getStats(i);
            }
        }
        if (chosen == null) {
            throw new IllegalArgumentException();
        }
        if (j > 0) {
            chosen.like();
        }
        else {
            chosen.dislike();
        }
    }
}

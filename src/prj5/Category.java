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

    private Stats stats1;
    private Stats stats2;
    private Stats stats3;
    private Stats stats4;


    public Category(SubEnum sub1, SubEnum sub2, SubEnum sub3, SubEnum sub4) {
        stats1 = new Stats(sub1);
        stats2 = new Stats(sub2);
        stats3 = new Stats(sub3);
        stats4 = new Stats(sub4);
    }


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
     * @param sub
     *          the subcategory to update
     * @param j
     *          a positive or negative value indicating liked or disliked
     */
    public void updateData(SubEnum sub, int j) {
        Stats chosen = null;
        for (int i = 1; i <= 4; i++) {
            if (getStats(i).getSubCategory().equals(sub)) {
                chosen = getStats(i);
            }
        }
        if (j == 1) {
            chosen.like();
        }
        else {
            chosen.dislike();
        }
    }
}

/**
 * 
 */
package prj5;

/**
 * @author davidd14
 * @version 2019.11.13
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


    /**
     * returns the string form of the category
     * 
     * @return
     *         returns the string in the following form:
     *         "First Stats toString()
     *         Second Stats toString()
     *         Third Stats toString()
     *         Fourth Stats toString()"
     */
    @Override
    public String toString() {
        return stats1.toString() + "\n" + stats2.toString() + "\n" + stats3
            .toString() + "\n" + stats4.toString();
    }


    /**
     * returns true if the object is equals to this object
     * 
     * @param obj
     *            the other object to compare to
     * @return
     *         returns true if obj is the same class and has equal Stats objects
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == this.getClass()) {
            Category other = (Category)obj;
            return (other.getStats(1).equals(stats1) && other.getStats(2)
                .equals(stats2) && other.getStats(3).equals(stats3) && other
                    .getStats(4).equals(stats4));
        }
        return false;
    }
}

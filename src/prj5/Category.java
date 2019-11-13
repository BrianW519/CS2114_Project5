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
}

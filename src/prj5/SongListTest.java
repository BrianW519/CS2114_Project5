package prj5;

import java.util.Iterator;
import student.TestCase;

/**
 *
 * @author Brian Wood brianwood
 * @author Dave
 * @author David
 * @version Nov 13, 2019
 */

public class SongListTest extends TestCase {
   private SongList<String> list;
   /**
    * sets up the tests
    */
   @Override
   public void setUp() {
       list = new SongList<String>();
   }

   /**
    * tests RemoveIndex
    */
   public void testRemoveIndex() {
       list.add("A");
       list.add("B");
       assertTrue(list.remove(1));
       assertEquals(list.getSize(), 1);
       list.add("B");
       assertTrue(list.remove(1));
       assertEquals(list.getSize(), 1);
       Exception exception = null;
       try {
           list.remove(500);
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
       exception = null;
       try {
           list.remove(-500);
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
   }

   /**
    * tests Add
    */
   public void testAdd() {
       assertEquals(0, list.getSize());
       list.add("B");
       assertEquals(1, list.getSize());
       list.add("C");
       assertEquals("C", list.getEntry(1));
       Exception exception = null;
       try {
           list.add(null);
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
       list.clear();
       list.add("A");
       exception = null;
       try {
           list.add(2, "B");
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
       exception = null;
       try {
           list.add(-1, "B");
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
   }

   /**
    * tests AddIndex
    */
   public void testAddIndex() {
       list.add("B");
       list.add(0, "A");
       assertEquals("B", list.getEntry(1));
       list.add(2, "W");
       assertEquals("W", list.getEntry(2));
       Exception exception = null;
       try {
           list.add(0, null);
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
   }
   /**
    * tests Remove
    */
   public void testRemove() {
       assertFalse(list.remove(null));
       list.add("A");
       list.add("B");
       assertTrue( list.remove("A"));
       assertEquals( "B", list.getEntry(0));
       assertEquals( 1, list.getSize());
       list.add("C");
       assertTrue(list.remove("C"));
       assertEquals("B", list.getEntry(0));
   }

   /**
    * tests get
    */
   public void testGet() {
       list.add("A");
       list.add("B");
       assertEquals(list.getEntry(1), "B");
       Exception exception = null;
       try {
           list.getEntry(-30);
       } 
       catch (Exception e) {
           exception = e;
       }
       assertNotNull(exception);
       exception = null;
       list.add("A");
       try {
           list.getEntry(30);
       } 
       catch (IndexOutOfBoundsException e) {
           exception = e;
       }
       assertNotNull(exception);
   }

   /**
    * tests isEmpty
    */
   public void testIsEmpty() {
       assertTrue( list.isEmpty());
       list.add("A");
       assertFalse(list.isEmpty());
   }

   /**
    * tests clear
    */
   public void testClear() {
       list.add("A");
       list.clear();
       assertEquals(0, list.getSize());
   }

   /**
    * tests toString
    */
   public void testToString() {
       assertEquals("[]",
               list.toString());
       list.add("A");
       assertEquals("[A]",
               list.toString());
       list.add("B");
       assertEquals("[A, B]",
               list.toString());
   }
   /**
    * test Itorator
    */
   public void testItorator() {
       SongList<String> inventory = new SongList<String>();
       Iterator<String> iter = inventory.iterator();
       Exception ex = null;
       try {
           iter.next();
       } 
       catch (Exception e) {
           ex = e;
       }
       assertNotNull(ex);
       ex = null;
       try {
           iter.remove();
       } 
       catch (Exception e) {
           ex = e;
       }
       assertNotNull(ex);
       assertFalse(iter.hasNext());   
       inventory.add("A");
       assertEquals(iter.next(), "A");
       iter.remove();
   }
   /**
    * test InsertionSort
    */
   public void testInsertionSort() {
       list.add("D");
       list.add("E");
       list.add("C");
       list.add("C");
       list.add("B");
       list.add("A");
       assertEquals(list.toString(), "[D, E, C, C, B, A]");
       list.insertionSort();
       assertEquals(list.toString(), "[A, B, C, C, D, E]");
   }

}


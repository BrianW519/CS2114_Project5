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
    private SongList<Song> songList;
    private Song song1;
    private Song song2;
    private Song song3;


    /**
     * sets up the tests
     */
    @Override
    public void setUp() {
        song1 = new Song("one", "styx", "rock", 1);
        song2 = new Song("two", "beedles", "rock", 2);
        song3 = new Song("three", "perry", "conser", 3);
        songList = new SongList<Song>();
    }


    /**
     * tests RemoveIndex
     */
    public void testRemoveIndex() {
        // assertTrue(songList.remove(3));
        songList.add(song1);
        songList.add(song2);
        assertTrue(songList.remove(1));
        assertEquals(songList.getSize(), 1);
        songList.add(song3);
        assertTrue(songList.remove(1));
        assertEquals(songList.getSize(), 1);
        Exception exception = null;
        try {
            songList.remove(500);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        exception = null;
        try {
            songList.remove(-500);
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
        assertEquals(0, songList.getSize());
        songList.add(song1);
        assertEquals(1, songList.getSize());
        songList.add(song3);
        assertEquals(song3, songList.getEntry(1));
        Exception exception = null;
        try {
            songList.add(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        songList.clear();
        songList.add(song2);
        exception = null;
        try {
            songList.add(2, song3);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        exception = null;
        try {
            songList.add(-1, song3);
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
        songList.add(song1);
        songList.add(0, song2);
        assertEquals(song1, songList.getEntry(1));
        songList.add(2, song3);
        assertEquals(song3, songList.getEntry(2));
        Exception exception = null;
        try {
            songList.add(0, null);
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
        assertFalse(songList.remove(null));
        songList.add(song1);
        songList.add(song2);
        songList.remove(0);
        assertEquals(song2, songList.getEntry(0));
        songList.remove(song2);
        assertTrue(songList.isEmpty());
    }


    /**
     * tests get
     */
    public void testGet() {
        songList.add(song1);
        songList.add(song2);
        assertEquals(songList.getEntry(1), song2);
        Exception exception = null;
        try {
            songList.getEntry(-30);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        exception = null;
        try {
            songList.getEntry(30);
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
        assertTrue(songList.isEmpty());
        songList.add(song1);
        assertFalse(songList.isEmpty());
    }


    /**
     * tests clear
     */
    public void testClear() {
        songList.add(song1);
        songList.clear();
        assertEquals(0, songList.getSize());
    }


    /**
     * tests toString
     */
    public void testToString() {

        assertEquals("[]", songList.toString());
        songList.add(song1);
        assertEquals(songList.toString(), "[one, styx, 1, rock]");
        songList.add(song2);
        assertEquals(songList.toString(),
            "[one, styx, 1, rock | two, beedles, 2, rock]");

    }


    /**
     * test Itorator
     */
    public void testItorator() {
        SongList<Song> inventory = new SongList<Song>();
        Iterator<Song> iter = inventory.iterator();
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
        inventory.add(song1);
        assertEquals(iter.next(), song1);
        iter.remove();
    }


    /**
     * test InsertionSort
     */
    public void testInsertionSort() {
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.insertionSort(Song.COMPARE_BY_TITLE);
        assertEquals(song3, songList.getEntry(1));
    }
}

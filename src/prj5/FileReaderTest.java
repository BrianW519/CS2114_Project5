package prj5;

import java.io.FileNotFoundException;
import java.util.Iterator;
import bsh.ParseException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Brian Wood (brianwood)
/**
 * Description
 *
 * @author Brian Wood brianwood
 * @version Nov 16, 2019
 */
public class FileReaderTest extends student.TestCase {

    private FileReader fileReader;


    /**
     * Sets up the variable before each test
     */
    public void setUp() throws FileNotFoundException {
        try {
            fileReader = new FileReader("MusicSurveyData2018Intro.csv",
                "SongList2018Intro.csv");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * Tests to make sure the method works as expected
     */
    public void testReadSongFile() {
        SongList<Song> songs = fileReader.getSongList();
        songs.insertionSort(Song.COMPARE_BY_DATE);
        Iterator<Song> iter = songs.iterator();
        assertEquals("Creep", iter.next().getTitle());
        String str =
            "[Creep, Radiohead, 1992, Alternative | My Heart Will Go On, "
                + "Celine Dion, 1997, Pop | All of Me, John Legend, 2013, R&B]";
        assertEquals(str, songs.toString());
    }


    /**
     * Tests to make sure the method works as expected
     */
    public void testReadInputFile() {
        SongList<Song> songs = fileReader.getSongList();

        songs.insertionSort(Song.COMPARE_BY_DATE);
        Iterator<Song> iter = songs.iterator();
        iter.next();
        iter.next();
        Song song = iter.next();
        assertEquals(1, song.getCategory(CategoryEnum.MAJOR).getStats(3)
            .getLikes());
        assertEquals(0, song.getCategory(CategoryEnum.MAJOR).getStats(1)
            .getLikes());

    }
}

package prj5;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Comparator;
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


    public void setUp() throws ParseException, FileNotFoundException {
        fileReader = new FileReader(
            "IntermediateTestFiles/SongList2018Intro.csv", "");
    }
    
    public void testReadSongFile() {
        SongList<Song> songs = fileReader.getSongList();
        //songs.insertionSort();
        System.out.print(songs.toString());
        
    }
}

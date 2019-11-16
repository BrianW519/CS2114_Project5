package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * Description
 *
 * @author Brian Wood brianwood
 * @author Dave
 * @author David
 * @version Nov 13, 2019
 */
public class FileReader {

    private SongList<Song> songs;


    public FileReader(String songFile, String inputFile)
        throws ParseException,
        FileNotFoundException {

        readSongFile(songFile);
    }


    public SongList<Song> getSongList() {
        return songs;
    }


    private void readSongFile(String fileName)
        throws ParseException,
        FileNotFoundException {
        songs = new SongList<Song>();

        String title;
        String artist;
        int date;
        String genre;

        File fileTemp = new File(fileName);
        Scanner file = new Scanner(fileTemp);

        //Skips header lines
        file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] data = line.split(",");

            if (data.length < 4) {
                throw new ParseException(
                    "Not all data for the song is present");
            }
            title = data[0];
            artist = data[1];
            date = Integer.valueOf(data[2]);
            genre = data[3];

            Song song = new Song(title, artist, genre, date);
            songs.add(song);
        }

        file.close();
    }

}

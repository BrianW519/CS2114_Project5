package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
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


    public FileReader(String inputFile, String songFile)
        throws FileNotFoundException, ParseException {

        readSongFile(songFile);
        readInputFile(inputFile);
    }


    public SongList<Song> getSongList() {
        return songs;
    }


    private void readSongFile(String fileName) throws ParseException, FileNotFoundException {
        songs = new SongList<Song>();

        String title;
        String artist;
        int date;
        String genre;

        File fileTemp = new File(fileName);
        Scanner file = new Scanner(fileTemp);

        // Skips header lines
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


    private void readInputFile(String fileName) throws FileNotFoundException, ParseException {

        SubEnum hobby;
        SubEnum major;
        SubEnum region;

        File fileTemp = new File(fileName);
        Scanner file = new Scanner(fileTemp);

        // Skips header lines
        file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] data = line.split(",");

            switch (data[2]) {
                case "Computer Science":
                    major = SubEnum.COMPUTER_SCIENCE;
                    break;
                case "Math or CMDA":
                    major = SubEnum.MATH_CMDA;
                    break;
                case "Other Engineering":
                    major = SubEnum.OTHER_ENGINEERING;
                    break;
                case "Other":
                    major = SubEnum.OTHER;
                    break;
                default:
                    continue;
            }

            switch (data[3]) {
                case "Northeast":
                    region = SubEnum.NORTHEAST_USA;
                    break;
                case "United States (other than Southeast or Northwest)":
                    region = SubEnum.USA_OTHER;
                    break;
                case "Southeast":
                    region = SubEnum.SOUTHEAST_USA;
                    break;
                case "Outside of United States":
                    region = SubEnum.USA_OTHER;
                    break;
                default:
                    continue;
            }

            switch (data[4]) {
                case "reading":
                    hobby = SubEnum.READ;
                    break;
                case "sports":
                    hobby = SubEnum.SPORTS;
                    break;
                case "music":
                    hobby = SubEnum.MUSIC;
                    break;
                case "art":
                    hobby = SubEnum.ART;
                    break;
                default:
                    continue;
            }

            Iterator<Song> iter = songs.iterator();
            for (int i = 5; i < data.length; i += 2) {
                if (i + 1 < data.length) {
                    if (data[i].equals("Yes")) {
                        if (data[i + 1].equals("Yes")) {
                            iter.next().updateData(hobby, major, region, 1);
                        }
                        else if (data[i + 1].equals("No")) {
                            iter.next().updateData(hobby, major, region, -1);
                        }
                    }
                    else if (data[i].equals("No")) {
                        iter.next().updateData(hobby, major, region, 0);
                    }
                    else {
                        iter.next();
                    }
                }
                else if(i == data.length - 1) {
                    if (data[i].equals("No")) {
                        iter.next().updateData(hobby, major, region, 0);
                    }
                    else if(data[i].equals("Yes")) {
                        iter.next().updateData(hobby, major, region, 100);
                    }
                }
            }
        }

        file.close();
    }

}

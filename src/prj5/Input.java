/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * @author davidd14
 * @version 2019.11.17
 */
public class Input {

    /**
     * @param args
     * @throws FileNotFoundException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        FileReader reader = new FileReader(args[0], args[1]);
        SongList<Song> currentSongs = reader.getSongList();
        currentSongs.insertionSort(Song.compareByGenre);
        for (int i = 0; i < currentSongs.getSize(); i++) {
            Song current = currentSongs.getEntry(i);
            System.out.println("\n" + "Song Title: " + current.getTitle() + "\n"
                + "Song Artist: " + current.getArtistName() + "\n"
                + "Song Genre: " + current.getGenre() + "\n"
                + "Song Year: " + current.getDate() + "\n"
                + "Heard\n"
                + "reading: " + current.getCategory(CategoryEnum.HOBBY).getStats(4).getHeardSong() + "\n"
                + "art: " + current.getCategory(CategoryEnum.HOBBY).getStats(2).getHeardSong() + "\n"
                + "sports: " + current.getCategory(CategoryEnum.HOBBY).getStats(3).getHeardSong() + "\n"
                + "music: " + current.getCategory(CategoryEnum.HOBBY).getStats(1).getHeardSong() + "\n"
                + "Likes\n"
                + "reading: " + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n"
                + "art: " + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n"
                + "sports: "  + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n"
                + "music: "  + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n");
        }
        currentSongs.insertionSort(Song.compareByTitle);
        for (int i = 0; i < currentSongs.getSize(); i++) {
            Song current = currentSongs.getEntry(i);
            System.out.println("\n" + "Song Title: " + current.getTitle() + "\n"
                + "Song Artist: " + current.getArtistName() + "\n"
                + "Song Genre: " + current.getGenre() + "\n"
                + "Song Year: " + current.getDate() + "\n"
                + "Heard\n"
                + "reading: " + current.getCategory(CategoryEnum.HOBBY).getStats(4).getHeardSong() + "\n"
                + "art: " + current.getCategory(CategoryEnum.HOBBY).getStats(2).getHeardSong() + "\n"
                + "sports: " + current.getCategory(CategoryEnum.HOBBY).getStats(3).getHeardSong() + "\n"
                + "music: " + current.getCategory(CategoryEnum.HOBBY).getStats(1).getHeardSong() + "\n"
                + "Likes\n"
                + "reading: " + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n"
                + "art: " + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n"
                + "sports: "  + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n"
                + "music: "  + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes() + "\n");
        }
    }

}

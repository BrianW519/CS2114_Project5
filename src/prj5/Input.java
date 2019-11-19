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
    public static void printer(SongList<Song> currentSong) {
        for (int i = 0; i < currentSong.getSize(); i++) {
            Song current = currentSong.getEntry(i);
            System.out.println("Song Title: " + current.getTitle() + "\n"
                + "Song Artist: " + current.getArtistName() + "\n"
                + "Song Genre: " + current.getGenre() + "\n" + "Song Year: "
                + current.getDate() + "\n" + "Heard");

            int readingHeardPercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(4).getHeardPercent();
            int musicHeardPercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(1).getHeardPercent();
            int sportsHeardPercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(3).getHeardPercent();
            int artHeardPercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(2).getHeardPercent();

            int readingLikePercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(4).getLikePercent();
            int musicLikePercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(1).getLikePercent();
            int sportsLikePercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(3).getLikePercent();
            int artLikePercent = current.getCategory(CategoryEnum.HOBBY)
                .getStats(2).getLikePercent();

            System.out.println("reading:" + readingHeardPercent + " " + "art:"
                + artHeardPercent + " " + "sports:" + sportsHeardPercent + " "
                + "music:" + musicHeardPercent + "\n" + "Likes\n" + "reading:"
                + readingLikePercent + " " + "art:" + artLikePercent + " "
                + "sports:" + sportsLikePercent + " " + "music:"
                + musicLikePercent + "\n");
        }
    }


    /**
     * @param args
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        FileReader reader = new FileReader(args[0], args[1]);
        SongList<Song> currentSongs = reader.getSongList();
        currentSongs.insertionSort(Song.COMPARE_BY_GENRE);
        printer(currentSongs);
        currentSongs.insertionSort(Song.COMPARE_BY_TITLE);
        printer(currentSongs);
        
       // DataDisplay display = new DataDisplay();

    }
}

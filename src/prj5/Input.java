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
            System.out.println("\n" + "Song Title: " + current.getTitle() + "\n"
                + "Song Artist: " + current.getArtistName() + "\n"
                + "Song Genre:" + current.getGenre() + "\n" + "Song Year:"
                + current.getDate() + "\n" + "Heard\n" + "reading: " + current
                    .getCategory(CategoryEnum.HOBBY).getStats(4).getHeardSong()
                + " " + "art:" + current.getCategory(CategoryEnum.HOBBY)
                    .getStats(2).getHeardSong() + " " + "sports:" + current
                        .getCategory(CategoryEnum.HOBBY).getStats(3)
                        .getHeardSong() + " " + "music:" + current.getCategory(
                            CategoryEnum.HOBBY).getStats(1).getHeardSong()
                + "\n" + "Likes\n" + "reading:" + current.getCategory(
                    CategoryEnum.HOBBY).getStats(4).getLikes() + " " + "art:"
                + current.getCategory(CategoryEnum.HOBBY).getStats(4).getLikes()
                + " " + "sports:" + current.getCategory(CategoryEnum.HOBBY)
                    .getStats(4).getLikes() + " " + "music:" + current
                        .getCategory(CategoryEnum.HOBBY).getStats(4)
                        .getLikes());
        }
    }


    /**
     * @param args
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args) {
        try {

            FileReader reader = new FileReader(args[1],
                args[0]);
            SongList<Song> currentSongs = reader.getSongList();
            currentSongs.insertionSort(Song.COMPARE_BY_GENRE);
            printer(currentSongs);
            currentSongs.insertionSort(Song.COMPARE_BY_TITLE);
            printer(currentSongs);
        }
        catch (Exception e) {
        }

    }
}

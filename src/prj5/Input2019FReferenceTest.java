package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import student.testingsupport.annotations.Hint;

/**
 * Test text output for Music Visualization Project
 * 
 * @author margaretellis
 * @version 11-12-2015
 */
public class Input2019FReferenceTest extends student.TestCase {
    private String fileName;
    private Scanner fileData;


    /**
     * sets up any needed variables for test methods
     */
    public void setUp() {

        fileData = null;
    }


    /**
     * Test the program with the actual class survey data from 2018
     * using all of the songs and 3 responses that include missing data
     * in the middle and end of the row
     * Gathers the output from StdOut and compares it to
     * the expect output as stored in OutputTitleGenreHobby.txt
     * 
     */
    @Hint("The main method is not working properly with input files "
        + "MusicSurveyData2018Intro.csv and SongList2018Intro.csv")
    public void testMain09() throws java.io.IOException {

        Input.main(new String[] { "MusicSurveyData2018Intro.csv",
            "SongList2018Intro.csv" });

        fileName = "Output09_2018.txt";

        String outputTitleGenreHobby = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            outputTitleGenreHobby += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input files "
            + "MusicSurveyData2018Intro.csv and " + "SongList2018Intro.csv",
            outputTitleGenreHobby, systemOut().getHistory());

    }


    /**
     * Test the program with the actual class survey data from 2018
     * using less songs and less responses that include missing data
     * Gathers the output from StdOut and compares it to
     * the expect output as stored in OutputTitleGenreHobby.txt
     * 
     */
    @Hint("The main method is not working properly with input files "
        + "MusicSurveyData2018HolesLess.csv and SongList2018LessSong.csv")
    public void testMain11() throws java.io.IOException {

        Input.main(new String[] { "MusicSurveyData2018HolesLess.csv",
            "SongList2018LessSongs.csv" });

        fileName = "Output11_2018.txt";

        String outputTitleGenreHobby = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            outputTitleGenreHobby += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input files "
            + "MusicSurveyData2018SHolesLess.csv and "
            + "SongList2018LessSongs.csv", outputTitleGenreHobby, systemOut()
                .getHistory());

    }


    /**
     * Test the program with the actual class survey data from 2018
     * using half of the songs and 17 responses that include missing data
     * Gathers the output from StdOut and compares it to
     * the expect output as stored in OutputTitleGenreHobby.txt
     * 
     */
    @Hint("The main method is not working properly with input files "
        + "MusicSurveyData2018.csv and SongList2018.csv")
    public void testMain12() throws java.io.IOException {

        Input.main(new String[] { "MusicSurveyData2018HolesHalf.csv",
            "SongList2018HalfSongs.csv" });

        fileName = "Output12_2018.txt";

        String outputTitleGenreHobby = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            outputTitleGenreHobby += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input files "
            + "MusicSurveyData2018SHolesHalf.csv and "
            + "SongList2018HalfSongs.csv", outputTitleGenreHobby, systemOut()
                .getHistory());

    }

}

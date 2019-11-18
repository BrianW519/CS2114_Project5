/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author davidd14
 * @version 2019.11.18
 *
 */
public class DataDisplay {

    private Window window;
    private Button prev;
    private Button sortByArtist;
    private Button sortByTitle;
    private Button sortByYear;
    private Button sortByGenre;
    private Button next;
    private Button repHobby;
    private Button repMajor;
    private Button repRegion;
    private Button quit;
    private final int GLYPH_BAR_SPACING = 0;
    private final int GLYPH_BAR_HEIGHT = 10;
    private final int DEFAULT_BAR_LENGTH = 40;
    private final int GLYPH_TEXT_SPACING = 5;
    private Shape pole;
    private Shape bar1;
    private Shape bar2;
    private Shape bar3;
    private Shape bar4;
    private Shape bar5;
    private Shape bar6;
    private Shape bar7;
    private Shape bar8;


    public DataDisplay() {
        window = new Window();
        prev = new Button("<-- Prev ");
        window.addButton(prev, WindowSide.NORTH);
        sortByArtist = new Button("Sort by Artist Name");
        window.addButton(sortByArtist, WindowSide.NORTH);
        sortByTitle = new Button("Sort by Song Title");
        window.addButton(sortByTitle, WindowSide.NORTH);
        sortByYear = new Button("Sort by Release Year");
        window.addButton(sortByYear, WindowSide.NORTH);
        sortByGenre = new Button("Sort by Genre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        next = new Button("Next -->");
        window.addButton(next, WindowSide.NORTH);
        repHobby = new Button("Represent Hobby");
        window.addButton(repHobby, WindowSide.SOUTH);
        repMajor = new Button("Represent Major");
        window.addButton(repMajor, WindowSide.SOUTH);
        repRegion = new Button("Represent Region");
        window.addButton(repRegion, WindowSide.SOUTH);
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        pole = new Shape((window.getGraphPanelWidth() / 2) - (GLYPH_BAR_HEIGHT
            / 2), (window.getGraphPanelHeight() / 2) - (GLYPH_BAR_HEIGHT * 4
                + GLYPH_BAR_SPACING * 3 / 2), GLYPH_BAR_HEIGHT, GLYPH_BAR_HEIGHT
                    * 4 + GLYPH_BAR_SPACING * 5, Color.BLACK);
        window.addShape(pole);
        bar1 = new Shape(pole.getX() - DEFAULT_BAR_LENGTH, pole.getY() + 1
            * GLYPH_BAR_SPACING + 0 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT, Color.MAGENTA);
        bar2 = new Shape(pole.getX() - DEFAULT_BAR_LENGTH, pole.getY() + 2
            * GLYPH_BAR_SPACING + 1 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT, Color.BLUE);
        bar3 = new Shape(pole.getX() - DEFAULT_BAR_LENGTH, pole.getY() + 3
            * GLYPH_BAR_SPACING + 2 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT);
        bar4 = new Shape(pole.getX() - DEFAULT_BAR_LENGTH, pole.getY() + 4
            * GLYPH_BAR_SPACING + 3 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT, Color.GREEN);
        window.addShape(bar1);
        window.addShape(bar2);
        window.addShape(bar3);
        window.addShape(bar4);
        bar5 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 1
            * GLYPH_BAR_SPACING + 0 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT, Color.MAGENTA);
        bar6 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 2
            * GLYPH_BAR_SPACING + 1 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT, Color.BLUE);
        bar7 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 3
            * GLYPH_BAR_SPACING + 2 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT);
        bar8 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 4
            * GLYPH_BAR_SPACING + 3 * GLYPH_BAR_HEIGHT, DEFAULT_BAR_LENGTH,
            GLYPH_BAR_HEIGHT, Color.GREEN);
        window.addShape(bar5);
        window.addShape(bar6);
        window.addShape(bar7);
        window.addShape(bar8);
        TextShape songName = new TextShape(0, 0, "Example Song");
        TextShape songArtist = new TextShape(0, 0, "by Artist");
        songName.moveTo(pole.getX() + (pole.getWidth() / 2) - (songName.getWidth() / 2), pole.getY()
            - songName.getHeight() - songArtist.getHeight() - (GLYPH_TEXT_SPACING));
        songArtist.moveTo(pole.getX() + (pole.getWidth() / 2) - (songArtist.getWidth() / 2), pole.getY()
            - songArtist.getHeight() - (GLYPH_TEXT_SPACING));
        songName.setBackgroundColor(Color.WHITE);
        songArtist.setBackgroundColor(Color.WHITE);
        window.addShape(songName);
        window.addShape(songArtist);
    }

}

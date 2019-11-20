/*

package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author davidd14
 * @version 2019.11.18
 *
 
public class DataDisplay {

    private static final int GLYPH_BAR_SPACING = 0;
    private static final int GLYPH_BAR_HEIGHT = 10;
    private static final int DEFAULT_BAR_LENGTH = 40;
    private static final int GLYPH_TEXT_SPACING = 5;
    private static final int LEGEND_BUFFER = 8;


    /**
     * The constructor
     
    public DataDisplay() {

        Window window;
        Button prev;
        Button sortByArtist;
        Button sortByTitle;
        Button sortByYear;
        Button sortByGenre;
        Button next;
        Button repHobby;
        Button repMajor;
        Button repRegion;
        Button quit;
        Shape pole;
        Shape bar1;
        Shape bar2;
        Shape bar3;
        Shape bar4;
        Shape bar5;
        Shape bar6;
        Shape bar7;
        Shape bar8;

        window = new Window();

        // adding tons of buttons
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

        // sample glyph
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
        songName.moveTo(pole.getX() + (pole.getWidth() / 2) - (songName
            .getWidth() / 2), pole.getY() - songName.getHeight() - songArtist
                .getHeight() - (GLYPH_TEXT_SPACING));
        songArtist.moveTo(pole.getX() + (pole.getWidth() / 2) - (songArtist
            .getWidth() / 2), pole.getY() - songArtist.getHeight()
                - (GLYPH_TEXT_SPACING));
        songName.setBackgroundColor(Color.WHITE);
        songArtist.setBackgroundColor(Color.WHITE);
        window.addShape(songName);
        window.addShape(songArtist);
        TextShape legendTitle = new TextShape(0, 0, "Hobby Legend");
        TextShape legendHobby1 = new TextShape(0, 0, "Read");
        TextShape legendHobby2 = new TextShape(0, 0, "Art");
        TextShape legendHobby3 = new TextShape(0, 0, "Sports");
        TextShape legendHobby4 = new TextShape(0, 0, "Music");
        Shape legendPole = new Shape(0, 0, GLYPH_BAR_HEIGHT, GLYPH_BAR_HEIGHT
            * 3 + GLYPH_BAR_SPACING * 4, Color.BLACK);
        TextShape legendSongTitle = new TextShape(0, 0, "Song Title");
        TextShape legendHeard = new TextShape(0, 0, "Heard");
        TextShape legendLike = new TextShape(0, 0, "Likes");
        Shape border = new Shape(window.getGraphPanelWidth() - (legendTitle
            .getWidth() + (LEGEND_BUFFER * 3)), window.getGraphPanelHeight()
                - (LEGEND_BUFFER * 6) - legendTitle.getHeight() - legendHobby1
                    .getHeight() - legendHobby2.getHeight() - legendHobby3
                        .getHeight() - legendHobby4.getHeight()
                - legendSongTitle.getHeight() - legendPole.getHeight(),
            legendTitle.getWidth() + (LEGEND_BUFFER * 2), (LEGEND_BUFFER * 5)
                + legendTitle.getHeight() + legendHobby1.getHeight()
                + legendHobby2.getHeight() + legendHobby3.getHeight()
                + legendHobby4.getHeight() + legendSongTitle.getHeight()
                + legendPole.getHeight(), Color.WHITE);
        border.setBackgroundColor(Color.WHITE);
        border.setForegroundColor(Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);
        legendHobby1.setBackgroundColor(Color.WHITE);
        legendHobby2.setBackgroundColor(Color.WHITE);
        legendHobby3.setBackgroundColor(Color.WHITE);
        legendHobby4.setBackgroundColor(Color.WHITE);
        legendSongTitle.setBackgroundColor(Color.WHITE);
        legendHeard.setBackgroundColor(Color.WHITE);
        legendLike.setBackgroundColor(Color.WHITE);
        legendHobby1.setForegroundColor(Color.MAGENTA);
        legendHobby2.setForegroundColor(Color.BLUE);
        legendHobby3.setForegroundColor(Color.ORANGE);
        legendHobby4.setForegroundColor(Color.GREEN);
        legendTitle.moveTo(border.getX() + (border.getWidth() / 2)
            - (legendTitle.getWidth() / 2) - (LEGEND_BUFFER / 2), border.getY()
                + LEGEND_BUFFER);
        legendHobby1.moveTo(border.getX() + (LEGEND_BUFFER / 2), border.getY()
            + (LEGEND_BUFFER * 2) + legendTitle.getHeight());
        legendHobby2.moveTo(border.getX() + (LEGEND_BUFFER / 2), border.getY()
            + (LEGEND_BUFFER * 2) + legendTitle.getHeight() + legendHobby1
                .getHeight());
        legendHobby3.moveTo(border.getX() + (LEGEND_BUFFER / 2), border.getY()
            + (LEGEND_BUFFER * 2) + legendTitle.getHeight() + legendHobby1
                .getHeight() + legendHobby2.getHeight());
        legendHobby4.moveTo(border.getX() + (LEGEND_BUFFER / 2), border.getY()
            + (LEGEND_BUFFER * 2) + legendTitle.getHeight() + legendHobby1
                .getHeight() + legendHobby2.getHeight() + legendHobby3
                    .getHeight());
        legendSongTitle.moveTo(border.getX() + (border.getWidth() / 2)
            - (legendSongTitle.getWidth() / 2) - (LEGEND_BUFFER / 2), border
                .getY() + (LEGEND_BUFFER * 3) + legendTitle.getHeight()
                + legendHobby1.getHeight() + legendHobby2.getHeight()
                + legendHobby3.getHeight() + legendHobby4.getHeight());
        legendPole.moveTo(border.getX() + (border.getWidth() / 2) - (legendPole
            .getWidth() / 2), border.getY() + (LEGEND_BUFFER * 4) + legendTitle
                .getHeight() + legendHobby1.getHeight() + legendHobby2
                    .getHeight() + legendHobby3.getHeight() + legendHobby4
                        .getHeight() + legendSongTitle.getHeight());
        legendHeard.moveTo(legendPole.getX() - LEGEND_BUFFER - legendHeard
            .getWidth(), legendPole.getY() + (legendPole.getHeight() / 2)
                - (legendHeard.getHeight() / 2));
        legendLike.moveTo(legendPole.getX() + (LEGEND_BUFFER / 3) + legendPole
            .getWidth(), legendPole.getY() + (legendPole.getHeight() / 2)
                - (legendLike.getHeight() / 2));
        window.addShape(legendTitle);
        window.addShape(legendHobby1);
        window.addShape(legendHobby2);
        window.addShape(legendHobby3);
        window.addShape(legendHobby4);
        window.addShape(legendSongTitle);
        window.addShape(legendPole);
        window.addShape(legendHeard);
        window.addShape(legendLike);
        window.addShape(border);

    }

}
*/

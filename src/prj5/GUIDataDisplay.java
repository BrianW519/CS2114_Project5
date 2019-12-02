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
 */

public class GUIDataDisplay {

    private static final int GLYPH_BAR_SPACING = 0;
    private static final int GLYPH_BAR_HEIGHT = 10;
    private static final int DEFAULT_BAR_LENGTH = 40;
    private static final int GLYPH_TEXT_SPACING = 5;
    private static final int LEGEND_BUFFER = 8;
    private static final int DEFAULT_OFFSET = 50;
    // button fields
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

    // functional fields
    private SongList<Song> songList;
    private int displayIndex;
    private CategoryEnum currentCategory;


    /**
     * The constructor
     */

    public GUIDataDisplay(SongList<Song> inputList) {

        // default display properties
        this.songList = inputList;
        displayIndex = 1;
        currentCategory = CategoryEnum.HOBBY;
        songList.insertionSort(Song.COMPARE_BY_TITLE);
        // window
        window = new Window();
        // adding tons of buttons
        prev = new Button("<-- Prev ");
        prev.onClick(this, "clickedPrev");
        window.addButton(prev, WindowSide.NORTH);
        sortByArtist = new Button("Sort by Artist Name");
        sortByArtist.onClick(this, "clickedSortByArtist");
        window.addButton(sortByArtist, WindowSide.NORTH);
        sortByTitle = new Button("Sort by Song Title");
        sortByTitle.onClick(this, "clickedSortByTitle");
        window.addButton(sortByTitle, WindowSide.NORTH);
        sortByYear = new Button("Sort by Release Year");
        sortByYear.onClick(this, "clickedSortByYear");
        window.addButton(sortByYear, WindowSide.NORTH);
        sortByGenre = new Button("Sort by Genre");
        sortByGenre.onClick(this, "clickedSortByGenre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        next = new Button("Next -->");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);
        repHobby = new Button("Represent Hobby");
        repHobby.onClick(this, "clickedRepHobby");
        window.addButton(repHobby, WindowSide.SOUTH);
        repMajor = new Button("Represent Major");
        repMajor.onClick(this, "clickedRepMajor");
        window.addButton(repMajor, WindowSide.SOUTH);
        repRegion = new Button("Represent Region");
        repRegion.onClick(this, "clickedRepRegion");
        window.addButton(repRegion, WindowSide.SOUTH);
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
        musicBars();
        // update window graphics to default
        updateDisplay();

    }


    public void musicBars() {
        int CurrentXOffSet = DEFAULT_OFFSET;
        int currentYOffSet = (window.getGraphPanelHeight() / 2)
            - (GLYPH_BAR_HEIGHT * 4 + GLYPH_BAR_SPACING * 3 / 2) - 70;
        for (int i = 0; i < songList.getSize(); i++) {
            Song current = songList.getEntry(i);
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
            Shape pole;
            Shape bar1;
            Shape bar2;
            Shape bar3;
            Shape bar4;
            Shape bar5;
            Shape bar6;
            Shape bar7;
            Shape bar8;
            pole = new Shape(CurrentXOffSet, currentYOffSet, GLYPH_BAR_HEIGHT,
                GLYPH_BAR_HEIGHT * 4 + GLYPH_BAR_SPACING * 5, Color.BLACK);
            window.addShape(pole);
            // = new Shape(x, y, width, height, color)
            // the amount of people who have heard it in READING
            int thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)readingHeardPercent / 100.0));
            bar1 = new Shape(pole.getX() - thisLength, pole.getY() + 1
                * GLYPH_BAR_SPACING + 0 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT, Color.MAGENTA);
            // the amount of people who have heard it in ART
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)artHeardPercent / 100.0));
            bar2 = new Shape(pole.getX() - thisLength, pole.getY() + 2
                * GLYPH_BAR_SPACING + 1 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT, Color.BLUE);
            // the amount of people who have heard it in SPORTS
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)sportsHeardPercent / 100.0));
            bar3 = new Shape(pole.getX() - thisLength, pole.getY() + 3
                * GLYPH_BAR_SPACING + 2 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT);
            // the amount of people who have heard it in MUSIC
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)musicHeardPercent / 100.0));
            bar4 = new Shape(pole.getX() - thisLength, pole.getY() + 4
                * GLYPH_BAR_SPACING + 3 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT, Color.GREEN);
            window.addShape(bar1);
            window.addShape(bar2);
            window.addShape(bar3);
            window.addShape(bar4);
            // the amount of people who have Liked it in READING
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)readingLikePercent / 100.0));
            bar5 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 1
                * GLYPH_BAR_SPACING + 0 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT, Color.MAGENTA);
            // the amount of people who have Liked it in ART
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)artLikePercent / 100.0));
            bar6 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 2
                * GLYPH_BAR_SPACING + 1 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT, Color.BLUE);
            // the amount of people who have Liked it in SPORTS
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)sportsLikePercent / 100.0));
            bar7 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 3
                * GLYPH_BAR_SPACING + 2 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT);
            // the amount of people who have Liked it in MUSIC
            thisLength = (int)((double)DEFAULT_BAR_LENGTH
                * ((double)musicLikePercent / 100.0));
            bar8 = new Shape(pole.getX() + GLYPH_BAR_HEIGHT, pole.getY() + 4
                * GLYPH_BAR_SPACING + 3 * GLYPH_BAR_HEIGHT, thisLength,
                GLYPH_BAR_HEIGHT, Color.GREEN);
            window.addShape(bar5);
            window.addShape(bar6);
            window.addShape(bar7);
            window.addShape(bar8);
            TextShape songName = new TextShape(0, 0, songList.getEntry(i)
                .getTitle());
            TextShape songArtist = new TextShape(0, 0, songList.getEntry(i)
                .getArtistName());
            songName.moveTo(pole.getX() + (pole.getWidth() / 2) - (songName
                .getWidth() / 2), pole.getY() - songName.getHeight()
                    - songArtist.getHeight() - (GLYPH_TEXT_SPACING));
            songArtist.moveTo(pole.getX() + (pole.getWidth() / 2) - (songArtist
                .getWidth() / 2), pole.getY() - songArtist.getHeight()
                    - (GLYPH_TEXT_SPACING));
            songName.setBackgroundColor(Color.WHITE);
            songArtist.setBackgroundColor(Color.WHITE);
            window.addShape(songName);
            window.addShape(songArtist);
            CurrentXOffSet = DEFAULT_BAR_LENGTH * 2 + CurrentXOffSet
                + DEFAULT_OFFSET;
            if (CurrentXOffSet + DEFAULT_BAR_LENGTH * 2 > window
                .getGraphPanelWidth() - LEGEND_BUFFER) {
                currentYOffSet = currentYOffSet + DEFAULT_OFFSET * 2;
                CurrentXOffSet = DEFAULT_OFFSET;
            }

        }
    }


    public void clickedPrev(Button button) {
        displayIndex -= 8;
        updateDisplay();
    }


    public void clickedSortByArtist(Button button) {
        displayIndex = 0;
        songList.insertionSort(Song.COMPARE_BY_ARTIST);
        updateDisplay();
    }


    public void clickedSortByTitle(Button button) {
        displayIndex = 0;
        songList.insertionSort(Song.COMPARE_BY_TITLE);
        updateDisplay();
    }


    public void clickedSortByYear(Button button) {
        displayIndex = 0;
        songList.insertionSort(Song.COMPARE_BY_DATE);
        updateDisplay();
    }


    public void clickedSortByGenre(Button button) {
        displayIndex = 0;
        songList.insertionSort(Song.COMPARE_BY_GENRE);
        updateDisplay();
    }


    public void clickedNext(Button button) {
        displayIndex += 8;
        updateDisplay();
    }


    public void clickedRepHobby(Button button) {
        displayIndex = 1;
        currentCategory = CategoryEnum.HOBBY;
        updateDisplay();
    }


    public void clickedRepMajor(Button button) {
        displayIndex = 1;
        currentCategory = CategoryEnum.MAJOR;
        updateDisplay();
    }


    public void clickedRepRegion(Button button) {
        displayIndex = 1;
        currentCategory = CategoryEnum.REGION;
        updateDisplay();
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    private void updateDisplay() {
        if (displayIndex == 1) {
            prev.disable();
        }
        if (displayIndex + 8 > songList.getSize()) {
            next.disable();
        }
        // updates the glyphs and legend
        updateGlyphs();
        updateLegend();
    }


    private void updateGlyphs() {
        // update glyphs to display the proper data
        // TO DO
    }


    private void updateLegend() {
        // TO DO
        // needs functionality to change text when the category changes
        // DO NOT adjust the spacing, text Dave if the spacing is off
        TextShape legendTitle = new TextShape(0, 0, "");
        TextShape legendHobby1 = new TextShape(0, 0, "");
        TextShape legendHobby2 = new TextShape(0, 0, "");
        TextShape legendHobby3 = new TextShape(0, 0, "");
        TextShape legendHobby4 = new TextShape(0, 0, "");
        if (currentCategory == CategoryEnum.HOBBY) {
            legendTitle = new TextShape(0, 0, "Hobby Legend");
            legendHobby1 = new TextShape(0, 0, "Read");
            legendHobby2 = new TextShape(0, 0, "Art");
            legendHobby3 = new TextShape(0, 0, "Sports");
            legendHobby4 = new TextShape(0, 0, "Music");
        }
        else if (currentCategory == CategoryEnum.MAJOR) {
            legendTitle = new TextShape(0, 0, "Hobby Legend");
            legendHobby1 = new TextShape(0, 0, "Read");
            legendHobby2 = new TextShape(0, 0, "Art");
            legendHobby3 = new TextShape(0, 0, "Sports");
            legendHobby4 = new TextShape(0, 0, "Music");
        }
        else if (currentCategory == CategoryEnum.REGION) {
            legendTitle = new TextShape(0, 0, "Hobby Legend");
            legendHobby1 = new TextShape(0, 0, "Read");
            legendHobby2 = new TextShape(0, 0, "Art");
            legendHobby3 = new TextShape(0, 0, "Sports");
            legendHobby4 = new TextShape(0, 0, "Music");
        }
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

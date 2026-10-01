import java.awt.*;


// class containing common constants used in the Hangman game
public class CommonConstants {
    // file paths for game resources
    public static final String DATA_PATH = "data.txt"; // file path for game data
    public static final String IMAGE_PATH = "1.png";   // file path for image resources
    public static final String FONT_PATH = "Cartoonero.ttf"; // file path for font resources


    // color configuration for GUI
    public static final Color PRIMARY_COLOR = Color.decode("#14212D");    // primary color for GUI components
    public static final Color SECONDARY_COLOR = Color.decode("#FCA311");  // secondary color for GUI components
    public static final Color BACKGROUND_COLOR = Color.decode("#101820"); // background color for GUI components


    // size configuration for GUI components
    public static final Dimension FRAME_SIZE = new Dimension(540, 760);                  // size of the main frame
    public static final Dimension BUTTON_PANEL_SIZE = new Dimension(FRAME_SIZE.width,    // size of the button panel
            (int) (FRAME_SIZE.height * 0.42));
    public static final Dimension RESULT_DIALOG_SIZE = new Dimension((int) (FRAME_SIZE.width / 2), // size of result dialog
            (int) (FRAME_SIZE.height / 6));
}
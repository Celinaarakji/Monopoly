import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


// Class containing custom tools for the Hangman game
public class CustomTools {
    // Method to create a JLabel with an image
    public static JLabel loadImage(String resource) {
        BufferedImage image;
        try {
            // Read image from the resource file
            InputStream inputStream = CustomTools.class.getResourceAsStream(resource);
            image = ImageIO.read(inputStream);
            // Create a JLabel with the loaded image
            return new JLabel(new ImageIcon(image));
        } catch (Exception e) {
            // Print error message if an exception occurs
            System.out.println("Error: " + e);
        }
        return null;
    }


    // Method to update an existing JLabel with a new image
    public static void updateImage(JLabel imageContainer, String resource) {
        BufferedImage image;
        try {
            // Read image from the resource file
            InputStream inputStream = CustomTools.class.getResourceAsStream(resource);
            image = ImageIO.read(inputStream);
            // Set the icon of the JLabel to the new image
            imageContainer.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            // Print error message if an IO exception occurs
            System.out.println("Error: " + e);
        }
    }


    // Method to create a custom font from a resource file
    public static Font createFont(String resource) {
        // Get the font file path
        String filePath = CustomTools.class.getClassLoader().getResource(resource).getPath();


        // Replace any '%20' characters in the file path with spaces (fixes a bug)
        if (filePath.contains("%20")) {
            filePath = filePath.replaceAll("%20", " ");
        }


        // Create the font
        try {
            // Load the font file and create the font object
            File customFontFile = new File(filePath);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile);
            return customFont;
        } catch (Exception e) {
            // Print error message if an exception occurs
            System.out.println("Error: " + e);
        }
        return null;
    }


    // Method to hide characters in a word (replace letters with '*')
    public static String hideWords(String word) {
        String hiddenWord = "";
        // Iterate through each character in the word
        for (int i = 0; i < word.length(); i++) {
            // Replace letters with '*' and keep spaces unchanged
            if (!(word.charAt(i) == ' ')) {
                hiddenWord += "*";
            } else {
                hiddenWord += " ";
            }
        }
        return hiddenWord; // Return the hidden word
    }
}

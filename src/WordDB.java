import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


// Class to handle word database operations
public class WordDB {
    // HashMap to store categories as keys and arrays of words as values
    private HashMap<String, String[]> wordList;


    // ArrayList to store categories for random selection
    private ArrayList<String> categories;


    // Constructor to initialize the database
    public WordDB(){
        try{
            // Initialize HashMap and ArrayList
            wordList = new HashMap<>();
            categories = new ArrayList<>();


            // Get resource URL for word data
            URL resourceURL = getClass().getClassLoader().getResource(CommonConstants.DATA_PATH);


            // Check if resourceURL is null (resource not found)
            if(resourceURL == null) {
                throw new IOException("Resource not found: " + CommonConstants.DATA_PATH);
            }


            // Create BufferedReader to read data file
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceURL.openStream()));


            // Read each line of the data file
            String line;
            while((line = reader.readLine()) != null){
                // Split line by ","
                String[] parts = line.split(",");


                // First part represents category
                String category = parts[0];
                categories.add(category);


                // Remaining parts are words related to the category
                String values[] = Arrays.copyOfRange(parts, 1, parts.length);
                wordList.put(category, values);
            }


            // Check if wordList or categories are empty
            if(wordList.isEmpty() || categories.isEmpty()) {
                throw new IOException("Word list is empty.");
            }
        } catch(IOException e){
            // Print error if resource not found or word list is empty
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Method to load a challenge (random category and word)
    public String[] loadChallenge(){
        // Check if wordList or categories are empty
        if(wordList.isEmpty() || categories.isEmpty()) {
            System.out.println("Error: Word list is empty.");
            return null;
        }


        Random rand = new Random();


        // Randomly select a category
        String category = categories.get(rand.nextInt(categories.size()));


        // Get words related to the selected category
        String[] categoryValues = wordList.get(category);


        // Check if categoryValues is null or empty
        if(categoryValues == null || categoryValues.length == 0) {
            System.out.println("Error: No words found for category " + category);
            return null;
        }


        // Randomly select a word from the category
        String word = categoryValues[rand.nextInt(categoryValues.length)];


        // Return category and word as an array
        return new String[]{category.toUpperCase(), word.toUpperCase()};
    }
}

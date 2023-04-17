import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Unscrambler {
    public static void main(String[] args) {
        // Read in the filename of the German word list
        String filename = "german_words.txt";

        try {
            // Open the file
            Scanner scanner = new giScanner(new File(filename));

            // Loop through each word in the file
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                // Call the unscrambleWord function to unscramble the word
                String unscrambledWord = unscrambleWord(word);

                // Print out the unscrambled word
                System.out.println(unscrambledWord);
            }

            // Close the file
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    // Function to unscramble a German word
    public static String unscrambleWord(String word) {
        // Convert the word to a character array for easy manipulation
        char[] wordChars = word.toCharArray();

        // Loop through the character array and swap letters in pairs
        for (int i = 0; i < wordChars.length - 1; i += 2) {
            char temp = wordChars[i];
            wordChars[i] = wordChars[i+1];
            wordChars[i+1] = temp;
        }

        // Convert the character array back to a string and return it
        return new String(wordChars);
    }
}

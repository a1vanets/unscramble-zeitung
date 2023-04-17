import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Unscrambler {
    public static void main(String[] args) {
        // Read in the filename of the German word list
        String wordlistGerman = "wordlist-german.txt";

        // Create a new HashSet to store the Strings
        HashSet<String> stringSet = new HashSet<>();

        try {
            // Open the file
            Scanner scanner = new Scanner(new File(wordlistGerman));

            // Loop through each String in the file and add it to the HashSet
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                stringSet.add(string);
            }

            // Close the file
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + wordlistGerman);
        }

        System.out.println(stringSet.contains("Aachen"));

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

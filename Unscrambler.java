import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Unscrambler {
    public static void main(String[] args) {
        // Read in the filename of the German word list
        String wordlistGerman = "wordlist-german.txt";

        // Create a new HashSet to store the Strings
        StringStorage germanList = new StringStorage();

        try {
            // Open the file
            Scanner scanner = new Scanner(new File(wordlistGerman));

            // Loop through each String in the file and add it to the HashSet
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                germanList.addString(string, string);
            }

            // Close the file
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + wordlistGerman);
        }

        //Not working. Why?
        for (String s : getAllPermutations("geisvtliie")) {
            System.out.println(s);
            if (germanList.getString(s) != null) {
                System.out.println(s);
                break;
            }
        }

    }

    //
    public static List<String> getAllPermutations(String s) {
        List<String> permutations = new ArrayList<>();
        getAllPermutationsHelper(s, "", permutations);
        return permutations;
    }

    private static void getAllPermutationsHelper(String s, String currentPermutation, List<String> permutations) {
        // Base case: if the current permutation is the same length as the input string, add it to the list of permutations
        if (currentPermutation.length() == s.length()) {
            permutations.add(currentPermutation);
            return;
        }

        // Recursive case: for each remaining letter in the input string,
        // add it to the current permutation and call the helper function again
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (currentPermutation.indexOf(c) == -1) {
                getAllPermutationsHelper(s, currentPermutation + c, permutations);
            }
        }
    }
}

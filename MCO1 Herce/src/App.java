import java.util.*;

// Selection Sort without using objects

public class App {

    public static String[] createSuffix(String characters) { // running time: O(n) // creates an array of suffixes
        String[] suffixes = new String[characters.length()]; // array of strings with length = characters.length where suffixes will be stored

        for(int i=0; i<characters.length(); i++) { // cost: O(n)
            suffixes[i] = characters.substring(i); // the .substring() function returns the substring of characters variable i.e. "hello".substring(1) is "ello"
        }

        // NOTE: this is for checking the output of the function
        // for (String string : suffixes) {
        //     System.out.println(string);
        // }

        return suffixes; // return array of String
    }


    public static void selectionSort(String[] suffixes) {

        for(int i=0; i<suffixes.length - 1; i++) {              // cost: O(n) 
            for(int j=i+1; j<suffixes.length; j++) {            // cost: O(n) // j is always at the right of i in the array
                if(suffixes[i].compareTo(suffixes[j]) > 0) {    // checks whether arr[i] is lexicographically greater than arr[j]
                    String temp = suffixes[i];                  // swaps the values
                    suffixes[i] = suffixes[j];
                    suffixes[j] = temp;
                }
            }
        }
    }

    public static String randomString(int n) { // generates a random string from the alphabet {a, c, g, t} of length n
        String retval = "";
        Random rand = new Random();

        // create a string with randomized characters where n is the total number of characters
        for(int i=0; i<n; i++) { 
            retval = retval + "acgt".charAt(rand.nextInt(4)); // rand.nextInt() randomizes 
        }

        System.out.println(retval);

        return retval;
    }

    public static void main(String[] args) {

        String characters = randomString(5);
        String[] input = createSuffix(characters);
        
        System.out.println("Unsorted suffixes:");

        for(String string : input) {
            System.out.println(string);
        }
        System.out.println();
        
        System.out.println("Sorted suffixes:");
        
        selectionSort(input);

        for(String string : input) {
            System.out.println(string);
        }

        for(int i=0; i<characters.length(); i++) {
            System.out.print(Arrays.asList(createSuffix(characters)).indexOf(input[i]) + " "); 
        }

    }
}

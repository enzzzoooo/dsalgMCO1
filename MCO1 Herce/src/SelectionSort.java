import java.util.*;

// Selection Sort using 

public class SelectionSort {
    

    public static ArrayList<Suffix> createSuffix(String characters) { // running time: O(n^2) // creates an array of suffixes
        ArrayList<Suffix> suffixes = new ArrayList<>();

        for(int i=0; i<characters.length(); i++) { // cost: O(n)
            suffixes.add(new Suffix(characters.substring(i), i));
            // the .substring() function returns the substring of characters variable i.e. "hello".substring(1) is "ello"
            // the time complexity cost of .substring is O(n)
        }

        // NOTE: this is for checking the output of the function
        System.out.println("Unsorted:");
        for (Suffix suffix : suffixes) {
            System.out.println( suffix.getIndex() + " " + suffix.getStringDNA());
        }

        return suffixes; // return array of String
    }

    // running time:
    public static ArrayList<Suffix> selectionSort(ArrayList<Suffix> suffixes) {

        for(int i=0; i<suffixes.size() - 1; i++) {      // cost: O(n) 
            for(int j=i+1; j<suffixes.size(); j++) {    // cost: O(n)   // j is always at the right of i in the array
                // cost: O(nxm) // checks whether arr[i] is lexicographically greater than arr[j]
                if(suffixes.get(i).getStringDNA().compareTo(suffixes.get(j).getStringDNA()) > 0) {  
                    String tempString = suffixes.get(i).getStringDNA(); // swaps the values
                    suffixes.get(i).setStringDNA(suffixes.get(j).getStringDNA());
                    suffixes.get(j).setStringDNA(tempString);

                    int tempInt = suffixes.get(i).getIndex(); // swaps the values
                    suffixes.get(i).setIndex(suffixes.get(j).getIndex());
                    suffixes.get(j).setIndex(tempInt);
                }
            }
        }

        System.out.println("Sorted:");
        for (Suffix suffix : suffixes) {
            System.out.println( suffix.getIndex() + " " + suffix.getStringDNA());
        }

        return suffixes;
    }

    public static String randomString(int n) { // generates a random string from the alphabet {a, c, g, t} of length n
        String retval = "";
        Random rand = new Random();

        // create a string with randomized characters where n is the total number of characters
        for(int i=0; i<n; i++) { 
            retval = retval + "acgt".charAt(rand.nextInt(4)); // rand.nextInt() randomizes 
        }

        return retval;
    }

    public static void main(String[] args) {

        ArrayList<Suffix> suffixes = createSuffix(randomString(5));
        selectionSort(suffixes);

        // TODO: create a randomizer for characters
        // String characters = randomString(5);     // store a random string of letters {a, c, g, t} in characters variable
        // String[] input = createSuffix(characters);  // creates the suffixes and stores it inside an array of String
        
        // System.out.println("Unsorted suffixes:");

        // for(String string : input) {
        //     System.out.println(string);
        // }
        // System.out.println();
        
        // System.out.println("Sorted suffixes:");
        // selectionSort(input);

        // for(String string : input) {
        //     System.out.println(string);
        // }

        // for(int i=0; i<characters.length(); i++) {
        //     System.out.print(Arrays.asList(createSuffix(characters)).indexOf(input[i]) + " ");
        // }

    }
}

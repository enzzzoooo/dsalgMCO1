import java.util.*;

public class SelectionSort {
    
    public static void main(String[] args) {
        // recursive method for Empirical Analysis of Running Time: 
        // test(128); // starting at n = 128 and doubles per recursion

        // suffixes is an ArrayList of Suffix objects will store the Suffix objects returned by createSuffix(), 
        // randomString() generates a random string from the alphabet {a, c, g, t} of length n
        ArrayList<Suffix> suffixes = createSuffix(randomString(5));

        // NOTE: this is for checking the output of the function
        System.out.println("Unsorted:");
        for (Suffix suffix : suffixes) {
            System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
        }

        // selectionSort() sorts the objects in the suffixes ArrayList
        selectionSort(suffixes);

        // NOTE: this is for checking the output of selectionSort()
        System.out.println("\nSorted:");
        for (Suffix suffix : suffixes) {
            System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
        }   
        
    }

    // method used for Empirical Analysis of Running Time
    public static void test(int n) {
        System.out.println("n = " + n);

        // recursive case
        if(n<33554432){
            long sum = 0;
            int k = 10;

            for(int i=0; i<k; i++) {
                // createSuffix() returns an ArrayList of String that will contain the suffixes of the characters
                // randomString() returns a random string comprised of the letters = {a, c, g, t}
                ArrayList<Suffix> suffixes = createSuffix(randomString(n));

                // NOTE: this is for checking the output of the function
                // System.out.println("========================================\nUnsorted:");
                // for (Suffix suffix : suffixes) {
                //     System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
                // }

                // To get the running time, Systen.nanoTime() will be used
                // System.nanoTime() returns the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds.
                long startTime = System.nanoTime();
                selectionSort(suffixes);
                long duration = (System.nanoTime() - startTime);

                // NOTE: this is for checking the value of each runtime
                // System.out.println("\nRuntime: " + duration);
                sum = sum + duration;

                // NOTE: this is for checking the output of selectionSort()
                // System.out.println("\nSorted:");
                // for (Suffix suffix : suffixes) {
                //     System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
                // }    
            }

            System.out.println("Average Runtime = " + sum/k + "\n"); // computes the average of all the runtime tests

            test(n*2); // recursive statement
        }
    }

    public static ArrayList<Suffix> createSuffix(String characters) { // running time: O(nxn) = O(n^2) // creates an array of suffixes
        ArrayList<Suffix> suffixes = new ArrayList<>(); // ArrayList where Suffix objects will be stored

        for(int i=0; i<characters.length(); i++) { // cost: O(n)
            suffixes.add(new Suffix(characters.substring(i), i)); 
            // create a new Suffix object for each substring (suffixes)
            // the object will be stored in suffixes ArrayList
            // the .substring() function returns the substring of characters variable i.e. "hello".substring(1) is "ello"
            // the time complexity cost of .substring is O(n)
        }

        return suffixes; // return array of String
    }

    public static String randomString(int n) { // generates a random string from the alphabet {a, c, g, t} of length n
        String retval = "";
        Random rand = new Random(); // Random class is used for a random number generator

        // create a string with randomized characters where n is the total number of characters
        for(int i=0; i<n; i++) { 
            retval = retval + "acgt".charAt(rand.nextInt(4)); // rand.nextInt() randomizes 
        }

        return retval;
    }

    // running time:
    public static void selectionSort(ArrayList<Suffix> suffixes) {
        // long startTime = System.nanoTime();

        for(int i=0; i<suffixes.size() - 1; i++) {   // cost: O(n) 
            for(int j=i+1; j<suffixes.size(); j++) { // cost: O(n) // j is always at the right of i in the array
                
                // checks whether suffix(i) is lexicographically greater than suffix(j)
                // cost of compareTo(): O(nxm) where n = number of the strings, m = max length of the strings
                if(suffixes.get(i).getStringDNA().compareTo(suffixes.get(j).getStringDNA()) > 0) {  
                    // swaps the values of the String variables
                    String tempString = suffixes.get(i).getStringDNA();           // store the value of suffixes[i] to a temporary String for swapping
                    suffixes.get(i).setStringDNA(suffixes.get(j).getStringDNA()); // assign the value of suffixes[j] to suffixes[i]	 
                    suffixes.get(j).setStringDNA(tempString);                     // assign the value of tempString to suffixes[j]

                    // swaps the values of the int variables
                    int tempInt = suffixes.get(i).getIndex();             // store the value of suffixes[i] index to a temporary int variable for swapping
                    suffixes.get(i).setIndex(suffixes.get(j).getIndex()); // set the index of suffixes[j] to suffixes[i]	
                    suffixes.get(j).setIndex(tempInt);                    // set the value of tempString to suffixes[j] 
                }
            }
        }

        // long duration = (System.nanoTime() - startTime);
        // System.out.println("\nRuntime: " + duration);
    }
}

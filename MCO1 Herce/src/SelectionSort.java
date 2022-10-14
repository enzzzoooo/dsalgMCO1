import java.util.*;

public class SelectionSort {
    

    public static ArrayList<Suffix> createSuffix(String characters) { // running time: O(nxn) = O(n^2) // creates an array of suffixes
        ArrayList<Suffix> suffixes = new ArrayList<>();

        for(int i=0; i<characters.length(); i++) { // cost: O(n)
            suffixes.add(new Suffix(characters.substring(i), i));
            // the .substring() function returns the substring of characters variable i.e. "hello".substring(1) is "ello"
            // the time complexity cost of .substring is O(n)
        }

        return suffixes; // return array of String
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

    // running time:
    public static void selectionSort(ArrayList<Suffix> suffixes) {
        // long startTime = System.nanoTime();

        for(int i=0; i<suffixes.size() - 1; i++) {      // cost: O(n) 
            for(int j=i+1; j<suffixes.size(); j++) {    // cost: O(n) // j is always at the right of i in the array
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

        // long duration = (System.nanoTime() - startTime);
        // System.out.println("\nRuntime: " + duration);
    }

    public static void test(int n) {
        System.out.println("n = " + n);
        if(n<33554432){
            long sum = 0;
            int k = 10;

            for(int i=0; i<k; i++) {
                ArrayList<Suffix> suffixes = createSuffix(randomString(n));

                // NOTE: this is for checking the output of the function
                // System.out.println("========================================\nUnsorted:");
                // for (Suffix suffix : suffixes) {
                //     System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
                // }

                long startTime = System.nanoTime();
                selectionSort(suffixes);
                long duration = (System.nanoTime() - startTime);
                // System.out.println("\nRuntime: " + duration);
                sum = sum + duration;

                // NOTE: this is for checking the output of selectionSort()
                // System.out.println("\nSorted:");
                // for (Suffix suffix : suffixes) {
                //     System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
                // }    
            }

            System.out.println("Average Runtime = " + sum/k + "\n");

            test(n*2);
        }
    }

    public static void main(String[] args) {
        test(128); // starting at n = 128 and doubles per recursion
    }
}

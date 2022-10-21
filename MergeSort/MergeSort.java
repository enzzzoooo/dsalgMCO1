import java.util.ArrayList;
import java.util.Random;

public class MergeSort {

    public static void main(String args[]) {

        // recursive method for Empirical Analysis of Running Time:
        // test(128); // starting at n = 128 and doubles per recursion

        // suffixes is an ArrayList of Suffix objects will store the Suffix objects returned by createSuffix(),
        // randomString() generates a random string from the alphabet {a, c, g, t} of length n
        ArrayList<Suffix> suffixes = createSuffix(randomString(14));

        // NOTE: this is for checking the output of the function
        System.out.println("Unsorted:");
        for (Suffix suffix : suffixes) {
            System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
        }

        // selectionSort() sorts the objects in the suffixes ArrayList
        suffixes = mergeSort(suffixes);

        // NOTE: this is for checking the output of selectionSort()
        System.out.println("\nSorted:");
        for (Suffix suffix : suffixes) {
            System.out.println(suffix.getIndex() + " " + suffix.getStringDNA());
        }
    }

    // method used for Empirical Analysis of Running Time
    /*public static void test(int n) {
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
    }*/

    public static ArrayList<Suffix> createSuffix(String characters) { // running time: O(nxn) = O(n^2) // creates an array of suffixes
        ArrayList<Suffix> suffixes = new ArrayList<>(); // ArrayList where Suffix objects will be stored

        for(int i = 0; i < characters.length(); i++) { // cost: O(n)
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
        for(int i = 0; i < n; i++) {
            retval = retval + "acgt".charAt(rand.nextInt(4)); // rand.nextInt() randomizes
        }

        return retval;
    }

    public static ArrayList<Suffix> merge(ArrayList<Suffix> arrA, ArrayList<Suffix> arrB) {

        ArrayList<Suffix> arrC = new ArrayList<>(); // used to store the merged array
        int counter = 0;

        // while arrA and arrB have elements
        while (arrA.size() != 0 && arrB.size() != 0) {
            
            String tempA = arrA.get(0).getStringDNA();
            String tempB = arrB.get(0).getStringDNA();
            
            //using strings at index 0, compare the chars at index counter
            if (tempA.charAt(counter) > tempB.charAt(counter)) {
                arrC.add(arrB.get(0)); //add b[0] to the end of c
                arrB.remove(0);//remove b[0] from b
                counter = 0;
            }
            else if (tempA.charAt(counter) < tempB.charAt(counter)) {
                arrC.add(arrA.get(0)); //add a[0] to the end of c
                arrA.remove(0); //remover a[0] from a
                counter = 0;
            }
            // ASSUMPTION: no arrays have the same size
            // if the condition above not satisfied and the size limit of an array is reached
            // automatically assign that arr to the end of arrC
            else if (tempA.length() == counter + 1) {
                arrC.add(arrA.get(0));
                arrA.remove(0);
                counter = 0;
            }
            else if (tempB.length() == counter + 1) {
                arrC.add(arrB.get(0)); //add b[0] to the end of c
                arrB.remove(0);//remove b[0] from b
                counter = 0;
            }
            else {
                counter++;
            }
        }

        // while arrA has elements
        while (arrA.size() != 0) {
            arrC.add(arrA.get(0));
            arrA.remove(0);
        }

        // while arrB has elements
        while (arrB.size() != 0) {
            arrC.add(arrB.get(0));
            arrB.remove(0);
        }

        return arrC;
    }

    public static ArrayList<Suffix> mergeSort(ArrayList<Suffix> arr) {

        int midpoint = arr.size() / 2;
        ArrayList<Suffix> arrayOne = new ArrayList<>();
        ArrayList<Suffix> arrayTwo = new ArrayList<>();

        if (arr.size() == 1) {
            return arr;
        }

        for (int i = 0; i < midpoint; i++) {
            arrayOne.add(arr.get(i));
        }

        for (int j = midpoint; j < arr.size(); j++) {
            arrayTwo.add(arr.get(j));
        }

        arrayOne = mergeSort(arrayOne);
        arrayTwo = mergeSort(arrayTwo);
        return merge(arrayOne, arrayTwo);
    }
}

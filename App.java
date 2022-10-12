import java.util.Arrays;

public class App {

    public static String[] createSuffix(String characters) {
        String[] suffixes = new String[characters.length()];

        for(int i=0; i<characters.length(); i++) {
            suffixes[i] = characters.substring(i);
        }

        // NOTE: this is for checking the output of the function
        // for (String string : suffixes) {
        //     System.out.println(string);
        // }

        return suffixes;
    }

    public static String[] selectionSort(String[] suffixes) {
        String[] sortedSuffix = suffixes;

        for(int i=0; i<suffixes.length - 1; i++) {
            for(int j=i+1; j<suffixes.length; j++) {
                if(suffixes[i].compareTo(suffixes[j]) > 0) {
                    String temp = suffixes[i];
                    sortedSuffix[i] = suffixes[j];
                    sortedSuffix[j] = temp;
                }
            }
        }

        return sortedSuffix;
    }

    public static void main(String[] args) {

        // TODO: create a randomizer for characters
        String characters = "tgtgtgtgcaccg";
        String[] input = createSuffix(characters);
        
        System.out.println("Unsorted suffixes:");

        for (String string : input) {
            System.out.println(string);
        }
        System.out.println();
        
        System.out.println("Sorted suffixes:");
        
        String[] sortedSuffixes = selectionSort(input);

        for (String string : sortedSuffixes) {
            System.out.println(string);
        }

        for(int i=0; i<characters.length(); i++) {
            System.out.print(Arrays.asList(createSuffix(characters)).indexOf(sortedSuffixes[i]) + " ");
        }

    }
}

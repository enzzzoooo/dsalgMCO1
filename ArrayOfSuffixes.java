import java.util.ArrayList;

public class ArrayOfSuffixes {
    public static void main(String args[]) {

        StringBuilder myString = new StringBuilder("tgtgtgtgcaccg");
        ArrayList<String> suffixes = new ArrayList<String>();
        int size = myString.length();

        for (int i = 0; i < size; i++) {
            suffixes.add(myString.substring(0));
            myString.deleteCharAt(0);
        }

        //for testing the array of suffixes
        /*
        for (int i = 0; i < size; i++) {
            System.out.println(suffixes.get(i));
        }
        */
    }
}

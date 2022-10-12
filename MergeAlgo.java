import java.util.ArrayList;

public class MergeAlgo {

    public static ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b) {

        ArrayList<String> c = new ArrayList<>();
        boolean repeater = true;
        int counter = 0;

        // while a and b have elements
        while (a.size() != 0 && b.size() != 0) {
            //comparing a[0] and b[0] so compare their chars
            while (repeater) {
                if (a.get(0).charAt(counter) > b.get(0).charAt(counter)) {
                    c.add(b.get(0)); //add b[0] to the end of c
                    b.remove(0);//remove b[0] from b
                    repeater = false;
                }
                else if (a.get(0).charAt(counter) < b.get(0).charAt(counter)) {
                    c.add(a.get(0)); //add a[0] to the end of c
                    a.remove(0); //remover a[0] from a
                    repeater = false;
                }
                else if (a.get(0).length() == counter + 1) {
                    c.add(a.get(0));
                    a.remove(0);
                    repeater = false;
                }
                else if (b.get(0).length() == counter + 1) {
                    c.add(b.get(0)); //add b[0] to the end of c
                    b.remove(0);//remove b[0] from b
                    repeater = false;
                }
                else {
                    counter++;
                }
            }
            repeater = true;
            counter = 0;
        }

        while (a.size() != 0) {
            c.add(a.get(0));
            a.remove(0);
        }

        while (b.size() != 0) {
            c.add(b.get(0));
            b.remove(0);
        }

        return c;
    }
    public static ArrayList<String> mergeSort(ArrayList<String> a){

        int midpoint = a.size() / 2;
        ArrayList<String> arrayOne = new ArrayList<>();
        ArrayList<String> arrayTwo = new ArrayList<>();

        if (a.size() == 1) {
            return a;
        }

        for (int i = 0; i < midpoint; i++) {
            arrayOne.add(a.get(i));
        }

        for (int j = midpoint; j < a.size(); j++) {
            arrayTwo.add(a.get(j));
        }

        arrayOne = mergeSort(arrayOne);
        arrayTwo = mergeSort(arrayTwo);
        return merge(arrayOne, arrayTwo);
    }

    public static void main(String args[]) {

        StringBuilder myString = new StringBuilder("tgtgtgtgcaccg");
        ArrayList<String> suffixes = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<>();
        int size = myString.length();

        for (int i = 0; i < size; i++) {
            suffixes.add(myString.substring(0));
            myString.deleteCharAt(0);
        }

        //for testing the array of suffixes
        temp = mergeSort(suffixes);

        for (int i = 0; i < size; i++) {
            for (int  j = 0; j < size; j++) {
                if (temp.get(i).compareTo(suffixes.get(j)) == 0) {
                    System.out.print("[" + j + "]");
                }
            }
        }
    }
}
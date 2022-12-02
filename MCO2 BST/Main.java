import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int numWord = 10000;
        int k = 5;

        distributionCounter(k, numWord);
    }

    public static void distributionCounter(int k, int numWord) {

        String dnaSequence = randomString(numWord);

        // String dnaSequence = "aaaaaaaaaaaa";

        long startTime = System.nanoTime();
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println(dnaSequence);

        for(int count = 0; count + k <= numWord; count++){
            String suffixes = dnaSequence.substring(count, count + k);
            if(tree.search(tree.root,suffixes) == null){
                tree.insert(new Node(suffixes));
            } else {
                tree.search(tree.root, suffixes).occurrences++;
            }
        }
        long duration = (System.nanoTime() - startTime);
        System.out.println("\nRuntime: " + duration);

    /*    if(numWord >= 1000000) {
            tree.deleteTree(tree.root);
            System.out.println("next one");
            kmerDistribution(k+1, 10000);
        }
        else {
            tree.deleteTree(tree.root);
            System.out.println("next set of sizes");
            kmerDistribution(k, numWord*10);
        } */

    }

    // DONE
    public static String randomString(int n) { // generates a random string from the alphabet {a, c, g, t} of length n
        String retval = "";
        Random rand = new Random(); // Random class is used for a random number generator

        // create a string with randomized characters where n is the total number of characters
        for(int i=0; i<n; i++) {
            retval = retval + "acgt".charAt(rand.nextInt(4)); // rand.nextInt() randomizes
        }

        return retval;
    }
}

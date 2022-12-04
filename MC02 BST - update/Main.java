import java.util.Random;

public class Main {
	
    public static void main(String[] args) {

        int k = 5;
        int n = 10000;
        
    	String dnaString = randomString(n);
    				
		long startTime = System.nanoTime();
		Node treeRoot = kmerDistribution(k, n, dnaString);
		long duration = (System.nanoTime() - startTime);
		
		// for printing purposes
		System.out.println(dnaString + "\n");
		printDistribution(treeRoot); 
		System.out.println("\nk = " + k);
		System.out.println("n = " + n);
		System.out.println("Runtime of kmerDistribution() = " + duration + " ns");
    }

    // uses binary search tree to compute the k-mer distribution of a DNA string
    public static Node kmerDistribution(int k, int n, String dnaString) {
     
        BinarySearchTree tree = new BinarySearchTree();

        for(int i = 0; i + k <= n; i++){
            String subString = dnaString.substring(i, i + k);
            if(tree.search(tree.root,subString) == null){
                tree.insert(new Node(subString));
            } 
            else {
                tree.search(tree.root, subString).occurrences++;
            }
        }
        
        return tree.root;
    }

    // generates a random string of length n given the letters {a, c, g, t}
    public static String randomString(int n) {
    	
        String retval = "";
        Random rand = new Random();

        for(int i = 0; i < n; i++) {
            retval = retval + "acgt".charAt(rand.nextInt(4));
        }

        return retval;
    }
    
    // prints the k-mer distribution in-order traversal
    public static void printDistribution(Node node) {
    
    	if (node == null) {
    		return;
    	}
    	printDistribution(node.left);
    	System.out.println(node.getKey() + "   " + node.occurrences);
    	printDistribution(node.right); 	
    }  
}

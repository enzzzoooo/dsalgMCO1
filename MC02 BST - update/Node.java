public class Node {

    private String key;
    public Node parent = null;
    public Node right = null;
    public Node left =  null;
    public int occurrences = 1;

    // constructor
    public Node (String key){
        this.key = key;
    }

    // getter
    public String getKey() {
        return key;
    }
}
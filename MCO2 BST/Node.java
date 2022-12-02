public class Node {

    private String Key;
    public Node parent = null;
    public Node right = null;
    public Node left =  null;


    public int occurrences = 1;

    public Node (String getKey){
        this.Key = getKey;
    }

    public String getKey() {
        return Key;
    }
}

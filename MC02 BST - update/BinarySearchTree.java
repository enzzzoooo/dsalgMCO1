import java.util.Objects;

public class BinarySearchTree {

    Node root;

    // SEARCH - determines if a search key exists in the BST
    public Node search(Node node, String key){
        if(Objects.isNull(node) || (node.getKey().equals(key))){
            return node;
        }

        if(key.compareTo(node.getKey()) < 0){
            return search(node.left, key);
        }
        else {
            return search(node.right, key);
        }
    }

    // INSERT - adds a new node in the BST
    public void insert(Node node){

        Node tempParent = null;
        Node tempNode = this.root;

        while(!Objects.isNull(tempNode)){
            tempParent = tempNode;
            if(node.getKey().compareTo(tempNode.getKey())<0){
                tempNode = tempNode.left;
            } else if (node.getKey().compareTo(tempNode.getKey()) > 0){
                tempNode = tempNode.right;
            }
        }

        node.parent = tempParent;

        if(Objects.isNull(tempParent)){
            this.root = node;
        } else if (node.getKey().compareTo(tempParent.getKey()) < 0) {
            tempParent.left = node;
        } else if (node.getKey().compareTo(tempParent.getKey()) > 0) {
            tempParent.right = node;
        }
    }

    // DESTROY - BST becomes empty
    public void destroy(Node node){
        if(!Objects.isNull(node)){
            destroy(node.left);
            destroy(node.right);
            node = null;
        }
    }
}
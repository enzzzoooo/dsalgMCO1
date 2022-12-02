import java.util.Objects;

public class BinarySearchTree {

    Node root;

    // SEARCH; returns the
    public Node search(Node node, String key){
        if(Objects.isNull(node) || (node.getKey().equals(key))){
            return node;
        }

        if(key.compareTo(node.getKey()) < 0){
            return search(node.left, key);
        }
        else{
            return search(node.right, key);
        }
    }

    // INSERT; adds new node
    // node to be added
    public void insert(Node node){ // node is z

        Node tempParent = null; // y
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

    // DESTROY; bst will become empty
    public void deleteTree(Node node){
        if(!Objects.isNull(node)){
            deleteTree(node.left);
            deleteTree(node.right);
            node = null;
        }
    }
}

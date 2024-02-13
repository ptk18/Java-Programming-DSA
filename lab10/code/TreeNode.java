package lab10.code;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;

    public TreeNode(int d){
        data = d;
    }
    TreeNode root = null;

    @Override
    public String toString() {
        /* code 6 */
        if (left == null && right == null) {
            return "null<-" + data + "->null"; // No child
        } 
        else if (left == null) {
            return "null<-" + data + "->" + right.data; // Node with right child only
        } 
        else if (right == null) {
            return left.data + "<-" + data + "->null"; // Node with left child only
        } 
        else {
            return left.data + "<-" + data + "->" + right.data; // Both children
        }

    }
}


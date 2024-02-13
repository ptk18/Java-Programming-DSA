//Phyo Thi Khaing 65011466 Lab10
package lab10;
import lab10.code.TreeNode;

public class BST_65011466 {
    TreeNode root;
    public BST_65011466() { root = null; }
    public TreeNode getRoot() {
        return root;
    }
    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } 
        else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else { 
                    /* code 1*/
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } 
                else { //! (d < p.data)
                    if (cur.right != null)
                    /* code 2*/
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            } //while
        }
    } //insert by iteration
    public void printPreOrder() {
        printPreOrderRecurse(root);
    }
    private void printPreOrderRecurse(TreeNode node) {
    /* code 3*/
        if (node==null) return;
        System.out.print(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }
    private void printInOrderRecurse(TreeNode node) {
        /* code 4*/
        if(node==null) return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }
    public void printPostOrder() {
        printPostOrderRecurse(root);
    }
    private void printPostOrderRecurse(TreeNode node) {
        /* code 5*/
        if(node==null) return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null) return null;
        if (d == n.data) return n;
        /* code 7*/
        if (d < n.data)
            return searchRecurse(d, n.left);
        return searchRecurse(d, n.right);
    }

    public TreeNode searchIter(int key) {
        if (root.data == key)
            return root;
        TreeNode current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left != null)
                    current = current.left;
                }
            else {
                if (current.right != null)
                    current = current.right;
            }
            if (current.data == key)
                return current;
            /* code 8 */
            
        } //while
        return null;
    }
    public int height() {
        return root == null ? 0 : height(root);
    }
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        /* code 9 */
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public TreeNode findMaxFrom(TreeNode subtreeHead) {
        /* your code 10 */
        TreeNode current = subtreeHead;
        if(current == null){
            return null;
        }
        while(current.right != null){
            current = current.right;
        }
        return current;
    }
    public void delete(int d, TreeNode current) {
        if (current == null) return; //not found
        if (d < current.data)
            delete(d, current.left);
        else if (d > current.data)
            delete(d, current.right);
        else { //found ... time to delete
            if (current.left == null || current.right == null) { // 0 or 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                if (current.parent.left == current)
                    current.parent.left = q; //this node is left child
                else
                    current.parent.right = q;
                if (q != null) q.parent = current.parent;
            }
            else { // two children
                TreeNode q = findMaxFrom(current.left);
                    /* your code 11 */
                    delete(q.data, current.left);
                    if(current.parent.left == current)
                        current.parent.left = q;
                    else
                        current.parent.right = q;
                    q.left = current.left;
                    q.right = current.right;
            } // two children
            } //found
        }



    public static void demo1() {
        System.out.println("-----Demo1-----");
        int [] data = {2,1,3,4,5,6,7,8,9};
        BST_65011466 bst0 = new BST_65011466();
        for (int j = 0; j < data.length; j++)
        bst0.insert(data[j]);
        bst0.printInOrder();
        System.out.println("Tree height = " + bst0.height());
        
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        BST_65011466 bst = new BST_65011466();
        for (int j = 0; j < dat.length; j++){
            bst.insert(dat[j]);
        }
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());

        /*int[] test = {60,20,70,10,40,30,50};
        BST_65011466 mybst = new BST_65011466();
        for (int j = 0; j<test.length; j++){
            mybst.insert(test[j]);
        }
        mybst.printInOrder();
        System.out.println("Tree height = " + mybst.height());*/
        System.out.println();

        System.out.println("-----Demo2-----"); 
        demo2(bst);
        System.out.println();

        System.out.println("-----Demo3-----");
        demo3(bst);
        System.out.print("After deleting 12: ");
        bst.printInOrder();

        /*System.out.println("-search recursive---");
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(12)); // null<-12->null
        System.out.println(bst.search(1)); // null
        System.out.println(bst.searchRecurse(10, bst.getRoot()));
        //if searchRecurse and getRoot is available
        System.out.println("-search iterative---");
        System.out.println(bst.searchIter(20));
        System.out.println(bst.searchIter(25));
        System.out.println(bst.searchIter(12));
        //System.out.println(bst.searchIter(1));*/
    }
    public static void demo2(BST_65011466 bst) {
        //BST_65011466 bst = new BST_65011466();
        
        System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));
    }

    //uncomment demo2() invocation inside demo1()
    /*static void demo2(BST_65011466 bst) {
        System.out.println("-more traversal---");
        System.out.println("-InOrder traversal-");
        bst.printInOrder(); // 8 10 12 15 16 18 19 20 25 30
        System.out.println();

        System.out.println("-PostOrder traversal-");
        bst.printPostOrder(); // 8 12 10 16 19 18 30 25 20 15
        System.out.println();
        
        // demo3(bst);
    }*/
    public static void demo3(BST_65011466 bst) {
        bst.delete(12, bst.getRoot());
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(16)); // null<-16->null
        System.out.println(bst.search(10)); // 8<-10->null
        System.out.println(bst.search(12)); // not found
        }

    public static void main(String[] args) {
        demo1();
        //demo2();
        
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 20:29
 */
class Node {
    char value;
    Node left;
    Node right;
    public Node(char value) {
        this.value = value;
    }
}
public class BinaryTree {
    //人为来创建一个二叉树
    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right =  E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    // 前序遍历
    void preOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    void inOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }
    //求结点个数
    int getSize2(Node root){
        if(root == null) {
            return 0;
        }
        return getSize2(root.left)
                +getSize2(root.right)+1;
    }
    // 遍历思路-求结点个数
    static int size = 0;
    int getSize1(Node root){
        if(root == null) {
            return 0;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
        return size;
    }
    //求叶子结点个数
    int getLeafSize2(Node root){
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right==null){
            return 1;
        }
        return getLeafSize2(root.left)
                +getLeafSize2(root.right);
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    int getLeafSize1(Node root){
        if(root == null) {
            return 0;
        }
        if(root.left==null&& root.right==null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
        return leafSize;
    }
}

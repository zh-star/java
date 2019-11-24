import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 20:29
 */
class Node {
    char  value;
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
    void preOrderTraversal2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.value + " ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
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
    void inOrderTraversal2(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.empty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
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
    void postOrderTraversal2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node flag = null;
        Node cur = root;
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();

            if(cur.right == null || cur.right == flag) {
                System.out.print(cur.value + " ");
                stack.pop();
                flag = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }

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

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val) {
        if(root == null) {
            return null;
        }
        if(root.value == val) {
            return root;
        }
        Node ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        Node ret2 = find(root.right,val);
        if(ret2 != null) {
            return ret2;
        }
        return null;
    }

    void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print( cur.value + " ");
            if(cur.left != null ) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    void levelOrderTraversal2(Node root) {

    }
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root) {
        Queue<Node>  queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                //cur == null;说明所有的节点放完了
                break;
            }
        }
        //遍历队列元素，判断
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null) {
                return false;
            }
        }
        return true;

    }

    public int MaxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int left = MaxDepth(root.left) + 1;
        int right = MaxDepth(root.right) + 1;
        return left > right ? left : right;
    }



}

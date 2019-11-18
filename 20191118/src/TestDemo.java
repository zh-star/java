/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 20:18
 */
public class TestDemo {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);

    }
}

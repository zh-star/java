package package1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 18:45
 */
public class TestDemo1 {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        //System.out.println(root);

        System.out.println("=========前序=========");
        binaryTree.preorderTraversal(root);
        System.out.println();
        binaryTree.preorderTraversal2(root);
        System.out.println();

        System.out.println("==========中序=========");
        binaryTree.inorderTraversal(root);
        System.out.println();
        binaryTree.inorderTraversal2(root);
        System.out.println();

        System.out.println("==========后续=========");
        binaryTree.postorderTraversal(root);
        System.out.println();


    }
}

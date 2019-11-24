import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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

        System.out.println();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("迭代法前序");
        binaryTree.preOrderTraversal2(root);
        System.out.println();
        System.out.println("======================");

        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println("迭代法中序");
        binaryTree.inOrderTraversal2(root);
        System.out.println();
        System.out.println("======================");

        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("迭代法后序");
        binaryTree.postOrderTraversal2(root);
        System.out.println();
        System.out.println("======================");
       // System.out.println(binaryTree.getSize1(root));//所有节点
       // System.out.println(binaryTree.getLeafSize1(root));//叶子节点


        System.out.println("层序遍历");
        binaryTree.levelOrderTraversal(root);
        System.out.println(binaryTree.isCompleteTree(root));
        System.out.println(binaryTree.MaxDepth(root));
    }
}

package package6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 15:27
 */
public class Test {
    public static void main(String[] args){
        BinarySearchTree bTree = new BinarySearchTree();
        int[] array = {10,2,27,23,1,9,7};
        for (int i = 0; i < array.length; i++) {
            bTree.insert(array[i]);
        }
        bTree.PreOrder(bTree.root);
        System.out.println();
        bTree.InOrder(bTree.root);
        System.out.println();

        BinarySearchTree.Node node =  bTree.search(1);
        System.out.println(node.val);

        bTree.remove(10);
        bTree.PreOrder(bTree.root);
        System.out.println();
        bTree.InOrder(bTree.root);
        System.out.println();

    }
}

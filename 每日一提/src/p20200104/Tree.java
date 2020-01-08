package p20200104;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 23:07
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
    // 判断平衡树
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null) {
            return true;
        }
        if(Math.abs(length(root.left) - length(root.right)) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    // 求树的深度
    private int length(TreeNode root) {
        int length1 = 0;
        int length2 = 0;
        for(TreeNode cur = root;cur != null; cur = cur.left) {
            length1 ++;
        }
        for(TreeNode cur = root;cur != null; cur = cur.right) {
            length2 ++;
        }
        return length1 > length2 ? length1 : length2 ;
    }
}

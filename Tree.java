/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
         if(root == null) {
            return list;
        }
        list.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
         if(root == null) {
            return list;
        }
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);

        list.add(root.val);
        
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);
        return list;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
         if(root == null) {
            return list;
        }
        List<Integer> left = postorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(right);
        list.add(root.val);
        return list;
    }
}


//100. 相同的树
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //p  和  q 是两个二叉树的根节点
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q!=null) {
            return false;
        }
        if(p != null && q==null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        return 
        isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}



//572. 另一个树的子树

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q!=null) {
            return false;
        }
        if(p != null && q==null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        return 
        isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) {
            return false;
        }
        if(isSameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }
}


//二叉树的最大深度

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return (leftHight > rightHight) ? leftHight+1 : rightHight+1;
    }
}



//110. 平衡二叉树

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return (leftHight > rightHight) ? leftHight+1 : rightHight+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return Math.abs(leftHight-rightHight) < 2 &&
        isBalanced(root.left)&&
        isBalanced(root.right);

    }
}


//101. 对称二叉树
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree!=null || leftTree != null && rightTree==null) {
            return false;
        }
        if(leftTree == null && rightTree==null) {
            return true;
        }
       return (leftTree.val == rightTree.val) && 
        isSymmetricChild(leftTree.left,rightTree.right)&&
        isSymmetricChild(leftTree.right,rightTree.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
}





//1. 二叉树的构建及遍历
import java.util.*;
class Node {
    char value;
    Node left;
    Node right;
    public Node(char value) {
        this.value = value;
    }
}
public class Main {
    public static int i = 0;
    public static Node buildTree(String str) {
        Node root = null;
        if(str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i ++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else{
            i++;
        }
        return root;
    }
    public static void inOrderTraversal(Node root){
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Node root = buildTree(str);
        inOrderTraversal(root);
    }
}


//2. 二叉树的分层遍历 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        //队列的元素 就是一层数据
        while (!queue.isEmpty()) {
            int count = queue.size();//1  2
            //存放的是一层数据
            List<Integer> list = new ArrayList<>();
            while(count > 0) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val+" ");
                list.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;//1 0
            }
           ret.add(list);
        }
        return ret;
    }
}

//3.  236. 二叉树的最近公共祖先
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        if(leftNode != null && rightNode !=null) {
            return root;
        }
        if(leftNode != null) {
            return leftNode;
        }
        if(rightNode != null) {
            return rightNode;
        }
        return null;
    }
}

//4.二叉搜索树与双向链表 牛客网
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        if(leftNode != null && rightNode !=null) {
            return root;
        }
        if(leftNode != null) {
            return leftNode;
        }
        if(rightNode != null) {
            return rightNode;
        }
        return null;
    }
}



//5. 根据一棵树的前序遍历与中序遍历构造二叉树
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    
    public TreeNode prev = null;
    public void ConvertChild(TreeNode root) {
        if(root == null) {
            return;
        }
        ConvertChild(root.left);
        //左树已经结束
        root.left = prev;
        if(prev != null) {
            prev.right = root;
        }        
        prev = root;
        ConvertChild(root.right);
    }
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void tree2strChild(TreeNode t,StringBuilder sb) {
        if(t == null) {
            return;
        }
        sb.append(t.val);
        if(t.left == null) {
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else{
             sb.append("(");
             tree2strChild(t.left,sb);
             sb.append(")");
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }

    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }
}

        
        while(head != null && head.left != null ) {
            head = head.left;
        }
        return head;
    }
}


//接6. 根据一棵树的中序遍历与后序遍历构造二叉树（[课堂不讲解，课后完成作业]）
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int posIndex = 0;
    public TreeNode buildTreeChild(int[] inorder, int[] postorder,int inbegin,
    int inend) {
        //肯定会没有左树 没有右树
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posIndex]);
        //找到root在中序遍历数组当中的位置
        int rootIndex = findInorderIndex(
            inorder,inbegin,inend,postorder[posIndex]);
        if(rootIndex == -1) {
            return null;
        }
        posIndex--;//3 

        root.right = buildTreeChild(postorder,inorder,rootIndex+1,inend);

        root.left = buildTreeChild(postorder,inorder,inbegin,rootIndex-1);
       
        return root;
    }

    public int findInorderIndex(int[] inorder,int inbegin,int inend,int val) {
        for(int i = inbegin;i <= inend;i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }

    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        posIndex = postorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
}


//7. 二叉树创建字符串。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void tree2strChild(TreeNode t,StringBuilder sb) {
        if(t == null) {
            return;
        }
        sb.append(t.val);
        if(t.left == null) {
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else{
             sb.append("(");
             tree2strChild(t.left,sb);
             sb.append(")");
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }

    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }
}

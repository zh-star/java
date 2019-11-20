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


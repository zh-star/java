package package5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 9:37
 */
public class BinarySearchTree {
    /**
     * Created with IntelliJ IDEA.
     * Description:
     * User: GAOBO
     * Date: 2019-12-04
     * Time: 9:32
     */

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    public void insert(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                return;
            }
            if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }

        if(parent.val < key) {
            parent.right = node;
        }else {
            parent.left = node;
        }
    }

    public void prevOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    public void InOrder(Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.val+" ");
        InOrder(root.right);
    }

    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if(cur.val == key) {
                return cur;
            }else if(cur.val < key) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;

    }

    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                //删除
                removeNode(parent,cur);
                return;
            }else if(cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
    }

    /**
     *
     * @param parent 要删除节点的父亲节点
     * @param cur 代表要删除的节点
     */
    public void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        } else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        } else {
            //替换
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //target->右树当中最小的元素
            cur.val = target.val;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }


}

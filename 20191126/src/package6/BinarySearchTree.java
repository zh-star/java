package package6;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 15:27
 */
public class BinarySearchTree {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    //1.查找操作
    public Node search(int key) {
        if(root == null) {
            return null;
        }
        Node cur = root;
        while(cur != null) {
            if(cur.val == key) {
                return cur;
            } else if(cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    // 2.插入操作
    public void insert(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
        }
        Node cur = root;
        Node parent = null;
        while(cur != null) {
            if(root.val == key) {
                //等于要插入的值时，不进行插入，直接返回
                return;
            }
            parent = cur;
            if (root.val < key) {
                //插入到 右边
                cur = cur.right;
            } else {
                //插到左边
                cur = cur.left;
            }
        }
        if(parent.val < key) {
            parent.right = node;
        } else {
            parent.left = node;
        }
    }

    //3.删除操作
    public void remove(int key) {
        if(root == null) {
            return;
        }
        Node cur = root;
        Node parent = cur;
        while(cur != null) {
            if (root.val == key) {
                removeNode(parent,cur);
                return;
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if(cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if(cur.right == null){
            if(cur == root) {
                root = cur.left;
            } else if(cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            //要删除节点的左右都不为空
            Node targetParent = cur;
            Node target = cur.right; //从右边找最小的
            while(target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //循环结束 ，cur为要删除的节点
            // 替换
            cur.val = target.val;
            //删除
            if(target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }

    // 中序遍历
    public void InOrder(Node root) {
        if(root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.val + " ");
        InOrder(root.right);
    }

    //前序遍历
    public void PreOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
}

public class Test {
    public static void main(String[] args){
        testAddFist();
        testAddLast();
        testAddIndex();
        testContans();
        testRemove();
    }

    public static void testAddFist(){
        //测试头插
        System.out.println("头插：");
        LinkedList node = new LinkedList();
        node.addFist(1);
        node.addFist(2);
        node.addFist(3);
        node.addFist(4);
        node.display();
    }

    public static void testAddLast(){
        //测试尾插
        System.out.println("尾插");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.display();
    }

    public  static void testAddIndex(){
        System.out.println("任意位置插入节点");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.display();
        node.addIndex(0,5);
        node.display();
    }

    public static void testContans(){
        //测试某个节点是否存在链表中
        System.out.println("是否存在于链表中");
        LinkedList node = new LinkedList();
        //boolean ret1= node.contains(3);
        //System.out.println(ret1);
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        boolean ret2 = node.contains(4);
        System.out.println(ret2);
    }

    public static void testRemove(){
        //测试删除元素
        System.out.println("删除链表中的元素");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.remove(4);
        node.display();
    }
}

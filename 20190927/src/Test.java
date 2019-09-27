import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

public class Test {
    public static void main(String[] args){
        testAddFist();
        testAddLast();
        testAddIndex();
        testContains();
        testRemove();
    }

    public static void testAddFist(){
        System.out.println("头插");
        LinkedList node = new LinkedList();
        node.addFist(1);
        node.addFist(2);
        node.addFist(3);
        node.addFist(4);
        node.display();
    }

    public static void testAddLast(){
        System.out.println("尾插");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.display();
    }

    public static void testAddIndex(){
        System.out.println("任意位置插入");
        LinkedList node = new LinkedList();
        node.addIndex(0,1);
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.addIndex(3,5);
        node.display();
    }

    public static void testContains(){
        System.out.println("测试元素是否存在");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        boolean ret = node.contains(2);
        System.out.println(ret);
    }
    public static void testRemove(){
        System.out.println("测试删除元素的第一次出现的节点");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.display();
        node.remove(2);
        node.display();
    }
}

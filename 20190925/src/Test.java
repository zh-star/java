public class Test {
    public static void main(String[] args){
        testAddFist();
        testAddLast();
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
}

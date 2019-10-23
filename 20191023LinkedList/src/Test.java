/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 9:38
 */
public class Test {
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.display();
        System.out.println(list.get(3));
        list.addAtIndex(0,10);
        list.addAtIndex(1,11);
        list.addAtIndex(5,12);
        list.display();
        list.deleteAtIndex(6);
        list.display();


    }
    public static void main1(String[] args){
        LinkedList linkedList = new LinkedList();
//        linkedList.addFirst(2);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);
//        linkedList.display();
//        linkedList.addIndex(0,1);
//        linkedList.addIndex(1,6);
//        linkedList.addIndex(5,5);
//        //linkedList.addIndex(8,8);
//
//        linkedList.display();
//        System.out.println(linkedList.contains(13));
//
//        linkedList.remove(5);
//        linkedList.display();
//        linkedList.removeAllKey(2);
//        linkedList.display();

        linkedList.addLast(13);
        linkedList.addLast(21);
        linkedList.addLast(3);
        linkedList.addLast(40);
        //linkedList.addLast(5);
        linkedList.display();
        //linkedList.reverseList();
        //linkedList.display();
        Node node1 = linkedList.middleNode();
        System.out.println(node1.data);

        Node node2 = linkedList.findKthToTail(2);
        System.out.println(node2.data);

        linkedList.display(linkedList.partition(18));

    }

}

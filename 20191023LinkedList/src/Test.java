/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 9:38
 */
public class Test {
    public static Node getIntersectionNode(Node headA,Node headB){
        int lenA = 0;
        int lenB = 0;
        Node pL = headA;//长的
        Node pS = headB;//短的

        while (pL != null) {
            lenA++;
            pL = pL.next;
        }

        while (pS != null) {
            lenB++;
            pS = pS.next;
        }

        int len = lenA - lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }

        pL = headA;
        pS = headB;

        //pL肯定指向最长的单链表
        //pS肯定指向最短的单链表
        //len  肯定是一个正数

        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //pL和pS此时已经在同一期起跑线上了
        //可以一人一步走



        return  null;
    }
    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(1);
        //System.out.println(linkedList.chkPalindrome());
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addLast(1);
        linkedList1.addLast(2);
        linkedList1.addLast(3);
        linkedList1.addLast(2);
        linkedList1.addLast(1);
        Node node = getIntersectionNode(linkedList.head,linkedList1.head);
        System.out.println(node.data);
    }
    public static void main2(String[] args){
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

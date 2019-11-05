package ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 22:20
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

}
public class ListNode {
    //合并两个单链表
    public static Node mergeTwoLists(Node head1,Node head2) {
        Node newHead = new Node(-1);
        Node newTail = newHead;
        while(head1 != null && head2 != null) {
            if(head1.data > head2.data) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }
        if(head1 == null) {
            newTail.next = head2;
        }
        if(head2 == null) {
            newTail.next = head1;
        }
        return newHead.next;
    }
}

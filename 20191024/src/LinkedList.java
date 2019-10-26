/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 15:01
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {
    private ListNode head;
    //1.删除链表中等于给定值 **val** 的所有节点
    public ListNode removeElements(ListNode head, int val) {
        if(this.head == null) {
            return null;
        }
        //1.先删除除过头结点之外的节点
        ListNode prev = this.head;
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == val) {//&&
                //删除节点
                prev.next = cur.next;
                cur = cur.next;
            } else {
                //更新引用
                prev = cur;
                cur = cur.next;//&&
            }
        }
        //2.删除头结点
        if (this.head.val == val) {
            this.head = this.head.next;
        }
        return this.head;
    }

    //2. 反转一个单链表。
    public ListNode reverseList(ListNode head) {
        if(this.head == null || this.head.next == null) {
            return this.head;
        }
        ListNode prev = null;
        ListNode cur = this.head;//要反转的节点
        ListNode curNext = this.head.next;
        while(cur != null) {
            cur.next = prev;
            if(curNext == null) {
                break;
            }
            prev = cur;
            cur = curNext;
            curNext = cur.next;//&&
        }
        return cur;
    }
}

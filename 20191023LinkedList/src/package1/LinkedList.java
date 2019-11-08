package package1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 17:18
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

    //2. 两数相加
    //给出两个 非空 的链表用来表示两个非负的整数。
    // 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.补零
        int lenA = getLength(l1);
        int lenB = getLength(l2);
        //补两个链表长度差值个0
        if(lenA > lenB) {
            for(int i = 0; i < lenA - lenB; i ++) {
                addLater(l2);
            }
        } else {
            for(int i = 0; i < lenB - lenA; i ++) {
                addLater(l1);
            }
        }
        //2.从头开始遍历
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //新的链表用于存放两数相加的和
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        int sum = 0;
        int carry = 0;//存放进位
        //遍历链表
        while(cur1 != null || cur2 != null) {
            //求和
            sum = carry + cur1.val + cur2.val;
            newTail.next = new ListNode(sum % 10);
            newTail = newTail.next;
            carry = sum / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;

        }
        //如果进位还有值，则将其赋于链表后面
        if(carry > 0) {
            newTail.next = new ListNode(carry);
        }
        return newHead.next;
    }
    //求链表长度
    private int getLength(ListNode head) {
        int length = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            length ++;
        }
        return length;
    }
    //头插法，给短的链表插入0
    private void addLater(ListNode head) {
        ListNode node = new ListNode(0);
        if(head == null) {
            head = node;
            return;
        }
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //逆置单链表
    public ListNode reverse(ListNode head1) {
        ListNode prev = null;
        ListNode cur = head1;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            if(curNext == null) {

                break;
            }
            prev = cur;
            cur = curNext;
        }
        return cur;
    }
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
}

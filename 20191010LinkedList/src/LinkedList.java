import java.util.List;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {

    private ListNode head = null;
    //头插
    public void addFist(int elem){
        //先new一个新的节点,用于存放elem
        ListNode node = new ListNode(elem);
        //判断链表是否为空链表
        if(this.head == null){
            //空链表
            this.head = node;
            return;
        }
        //非空链表
        node.next = head;
        this.head = node;
        return;
    }
    //1.两数相加
    /*
    * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/add-two-numbers
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while(cur1 != null && cur2 != null) {
            //位数相同的数相加，也就是链表长度一样的两个数相加
            int sum = 0;
            sum = sum + cur1.val + cur2.val;//7  10
            if(sum >= 10) {
                newTail.next = new ListNode(sum % 10);
                newTail = newTail.next;

                if(cur1.next == null) {
                    newTail.next = new ListNode(sum / 10);
                    newTail = newTail.next;
                } else {
                    int sum1 = cur1.next.val + sum / 10;
                    cur1.next.val = sum1;
                }

            } else {
                newTail.next = new ListNode(sum);
                newTail = newTail.next;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;

        }
        //链表长度不同
        if(cur2 != null) {
            newTail.next = l2;
        } else if(cur1 != null){
            newTail.next = l1;
        }
        return newHead.next;
    }
}

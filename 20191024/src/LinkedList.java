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
    //汤老师版本
    public ListNode reverseList1(ListNode head) {
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
    //博哥版本
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;//要反转的节点
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            if(curNext == null) {
                break;
            }
            prev = cur;
            cur = curNext;
            curNext = cur.next;
        }
        return cur;
    }

    // 3.给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    //方法1
    public ListNode middleNode1(ListNode head) {
        int step = getLength() / 2;
        ListNode cur = this.head;
        for (int i = 0; i < step; i++) {
            cur = cur.next;
        }
        return cur;
    }
    private int getLength() {
        int length = 0;
        for (ListNode cur = this.head; cur != null; cur = cur.next) {
            length ++;
        }
        return length;
    }
    //方法2
    public ListNode middleNode(ListNode head) {
       ListNode fast = this.head;
       ListNode slow = this.head;
       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
        }
        return slow;
    }

    //4. 输入一个链表，输出该链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(this.head == null) {
            return null;
        }
        int length = getLength();
        if(k <= 0 || k > length) {
            return null;
        }
        int step = length - k;
        ListNode cur = this.head;
        for (int i = 0; i < step; i++) {
            cur = cur.next;
        }
        return  cur;
    }

    //5. 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newTail.next = new ListNode(cur1.val);
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                newTail.next = new ListNode(cur2.val);
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        //循环结束，表明有一个链表为空了
        if (cur1 == null) {
            newTail.next = cur2;
        }
        if (cur2 == null) {
            newTail.next = cur1;
        }
        return newHead.next;
    }

    //6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur!= null) {
            if(cur.next != null && cur.val == cur.next.val) {//&&
                //向后继续走
                while (cur.next != null && cur.val == cur.next.val) {//&&
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                //将这个节点放入新的链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    // 8.链表的回文结构

}

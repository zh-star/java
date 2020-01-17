package p2020_01.p20200107;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 20:56
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 第二题链表的相加 {

    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode p1 = a, p2 = b;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int sum = 0;
        while (p1 != null || p2 != null || sum != 0) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            sum /= 10;
            p = p.next;
        }
        return head.next;
    }

    public ListNode plusAB2(ListNode a, ListNode b) {
        // write code here
        ListNode newSumHead = new ListNode(-1);
        ListNode newSumTail = newSumHead;
        // 1. 反转两个链表
        ListNode cur1 = a;
        ListNode cur2 = b;
        // 2. 求和
        int jinwei = 0;
        while(cur1 != null) {
            int sum = jinwei +  cur1.val + cur2.val;
            // 没有进位
            if(sum < 10) {
                newSumTail.next = new ListNode(sum);
                newSumTail = newSumTail.next;
            } else {
                // 有进位
                newSumTail.next = new ListNode(sum%10);
                newSumTail = newSumTail.next;
                jinwei = sum / 10;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        newSumHead = reverse(newSumHead);

        newSumHead = remove(newSumHead);

        newSumHead = reverse(newSumHead);

        return newSumHead;
    }
    // 反转一个链表
    public ListNode reverse(ListNode head) {
        if(head == null){
            return head;
        }
        //只有一个元素的链表也不需要处理
        if(head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                head = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }

        return head;
    }

    public ListNode remove(ListNode head) {
        ListNode cur = head;
        while(cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
    public void display(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public ListNode addLater(int val,ListNode head) {
        ListNode node = new ListNode(val);
        if(head == null) {
            head = node;
            return head;
        }
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return head;
    }
    public ListNode addFist(int elem,ListNode head){
        //先new一个新的节点,用于存放elem
        ListNode node = new ListNode(elem);
        //判断链表是否为空链表
        if(head == null){
            //空链表
            head = node;
            return head;
        }
        //非空链表
        node.next = head;
        head = node;
        return head;
    }
}

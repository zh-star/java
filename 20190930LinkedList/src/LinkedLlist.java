class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class LinkedLlist {
    ListNode head = null;
    /*
    * 1.删除链表中等于给定值 val 的所有节点。
    * 示例:
    * 输入: 1->2->6->3->4->5->6, val = 6
    * 输出: 1->2->3->4->5
    * */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        //先处理后续节点，在处理头节点
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == val) {
                //删除此节点
                prev.next = cur.next;
                cur = prev.next;
            }else {
                //不删除节点，走向下一个节点
                prev = cur;
                cur = cur.next;
            }
        }
        //处理头节点
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }
    /*
    * 2.反转链表
    * 示例:
    * 输入: 1->2->3->4->5->NULL
    * 输出: 5->4->3->2->1->NULL
    * */
    public ListNode reverseList(ListNode head) {
        //空链表不需要处理
        if(head == null){
            return head;
        }
        //只有一个元素的链表也不需要处理
        if(head.next == null){
            return head;
        }
        //多个元素的链表
        //ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            if(next == null) {
                //newHead = cur;
                head = cur;
            }
            cur.next = prev;//反转引用
            //更新 prev 和 cur
            prev = cur;
            cur = next;
        }
        //return newHead;
        return head;
    }
    /*
    * 3.题目：链表的中间结点
    给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    如果有两个中间结点，则返回第二个中间结点。
    示例1：
    输入：[1,2,3,4,5]
    输出：此列表中的结点 3 (序列化形式：[3,4,5])
    示例2：
    输入：[1,2,3,4,5,6]
    输出：此列表中的结点 4 (序列化形式：[4,5,6])
    * */
    public ListNode middleNode(ListNode head) {
        //不管是奇数个还是偶数个，都是从头向后走 size/2 步
        int step = size(head)/2;
        ListNode cur = head;
        for(int i = 0; i < step; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //计算链表大小
    private int size(ListNode head) {
        int size = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    /*
    * 4.删除链表中等于给定值 val 的所有节点。
    * 示例:
    *输入: 1->2->6->3->4->5->6, val = 6
    *输出: 1->2->3->4->5
    * */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        //先处理后续节点，在处理头节点
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == val) {
                //删除此节点
                prev.next = cur.next;
                cur = prev.next;
            }else {
                //不删除节点，走向下一个节点
                prev = cur;
                cur = cur.next;
            }
        }
        //处理头节点
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }

    //5.合并两个有序链表
    /*题目：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    示例：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合法性校验
        if(l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //循环进行比较，并将较小的放在新的链表中
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null) {
            if(cur1.val < cur2.val) {
                //将cur1存到新链表中
                newTail.next = new ListNode(cur1.val);
                newTail = newTail.next;
                cur1 = cur1.next;
            }else {
                //将cur2存到新链表中
                newTail.next = new ListNode(cur2.val);
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        //循环结束，说明有一个链表为空，则另一个链表剩余的直接全部存入新的链表
        if(cur1 == null) {
            newTail.next = cur2;
        }else {
            newTail.next = cur1;
        }
        return newHead.next;
    }

    //6.链表分割
    // 题目描述：
    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    //给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
    // 注意：分割以后保持原来的数据顺序不变。
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        //合法性校验
        if(pHead == null ) {
            return null;
        }
        if(pHead.next == null) {
            return null;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for(ListNode cur = pHead; cur != null; cur = cur.next) {
            if(cur.val < x) {
                //放在小于x的链表中
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else {
                //放在大于x的链表中
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        //将 小于x 的链表放在 大于x的 链表之前
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //7.链表的回文结构
    /*
    * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    * 示例：
    *  1->2->2->1
    *   返回：true
    *
    * 思考：找到链表的中间位置结点，把之后的进行反转，再与前半部分进行比较
    * */
    public class PalindromeList {
        public boolean chkPalindrome(ListNode A) {
            // write code here
            //合法性校验
            if(A == null) {//空链表
                return true;
            }
            if(A.next == null){//只有一个元素
                return true;
            }
            //找到链表的中间位置
            int steps = size(A)/2;
            ListNode B = A;
            for(int i = 0; i < steps; i++) {
                B = B.next;
            }
            //循环结束，到达中间结点开始反转中间结点之后的链表
            ListNode prev = null;
            ListNode cur = B;
            while(cur != null) {
                ListNode next = cur.next;
                if(next == null) {
                    B = cur;
                }
                cur.next = prev;
                //更新prev  cur
                prev = cur;
                cur = next;
            }
            //判断是否相同
            while(B != null) {
                if(A.val != B.val) {
                    return false;
                }
                A = A.next;
                B = B.next;
            }
            return true;
        }
        //求链表大小
        public int size(ListNode head) {
            int size = 0;
            for(ListNode cur = head; cur != null; cur = cur.next) {
                size++;
            }
            return size;
        }
    }

    //8.

}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {

   // ListNode head = null;
    public void addLast(ListNode head ,int elem){
        ListNode node = new ListNode(elem);
        //判断是否为空链表
        if(head == null){
            //空链表
            head = node;
            return;
        }
        //非空链表
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }


    //https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
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

    //
}


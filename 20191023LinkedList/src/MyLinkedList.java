/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 20:33
 */
class ListNode {
    public int data;
    public ListNode next;

    public ListNode() {

    }
    public ListNode(int date) {
        this.data = date;
    }
}
class MyLinkedList {
    private ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size()) {
            return -1;
        }
        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
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

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        if(index < 0 || index > size()) {
            return;
        }
        if(index < 0) {
            node.next = this.head;
            this.head = node;
            return;
        }
        if(this.head == null ) {
            this.head = node;
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        //1.找前驱
        ListNode prev = this.head;
        for(int i = 0; i < index-1; i ++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        prev.next = node;
        node.next = cur;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size()) {
            return;
        }
        if(this.head == null) {
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        //找到index的前一个
        ListNode prev = this.head;
        for (int i = 0; i < index -1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    private int size() {
        int size = 0;
        for (ListNode cur = this.head; cur != null; cur = cur.next) {
            size ++;
        }
        return size;
    }


    public void display() {
        System.out.print("[");
        for (ListNode cur = this.head; cur != null; cur = cur.next) {
            System.out.print(cur.data);
            if (cur.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");

    }
}




/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
